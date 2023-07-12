package com.b2win.projectbowl.member.entity;

import com.b2win.projectbowl.member.dto.MemberDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member {

    public enum Gender {
        MALE, FEMALE
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 100, unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;


    @Column(nullable = false, updatable = false, unique = true)
    private String Id;

    @Column(length = 300, nullable = false)
    private String password;

    @Column(nullable = true, updatable = false, unique = true)
    private String email;

//    @ElementCollection(fetch = FetchType.EAGER)
//    private List<String> roles = new ArrayList<>();

    public static Member toSaveMember(MemberDto.Post requestBody) {
        if (requestBody == null) {
            return null;
        }

        Member member = new Member();
        member.setName(requestBody.getName());
        member.setBirthDate(requestBody.getBirthDate());
        member.setGender(requestBody.getGender());
        member.setId(requestBody.getId());
        member.setPassword(requestBody.getPassword());
        if (requestBody.getEmail() != null) {
            member.setEmail(requestBody.getEmail());
        } else member.setEmail(null);

        return member;

    }

}