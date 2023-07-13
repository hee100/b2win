package com.b2win.projectbowl.member.service;

import com.b2win.projectbowl.exception.BusinessLogicException;
import com.b2win.projectbowl.exception.ExceptionCode;
import com.b2win.projectbowl.member.entity.Member;
import com.b2win.projectbowl.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    public Member createMember(Member member) {
        verifyExistsEmail(member.getId());
        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        // 추가: User Role DB에 저장
//        List<String> roles = authorityUtils.createRoles(member.getEmail());
//        member.setRoles(roles);

        Member savedMember = memberRepository.save(member);


        return savedMember;
    }

    private void verifyExistsEmail(String userId) {
        Optional<Member> member = memberRepository.findById(userId);
        if (member.isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }

}
