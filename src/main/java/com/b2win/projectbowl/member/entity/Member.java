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

    @Setter
    @Column(length = 300, nullable = false)
    private String password;

    @Column(nullable = true, updatable = false, unique = true)
    private String email;

//    @ElementCollection(fetch = FetchType.EAGER)
//    private List<String> roles = new ArrayList<>();

    @Builder
    public Member(Long memberId, String name, LocalDate birthDate, Gender gender, String id, String password, String email) {
        this.memberId = memberId;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.Id = id;
        this.password = password;
        this.email = email;
    }

    public static Member toSaveMember(MemberDto.Post requestBody) {

        return Member.builder()
                    .name(requestBody.getName())
                    .birthDate(requestBody.getBirthDate())
                    .gender(requestBody.getGender())
                    .id(requestBody.getId())
                    .password(requestBody.getPassword())
                    .email(requestBody.getEmail())
                    .build();

    }

}