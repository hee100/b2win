package com.b2win.projectbowl.member.service;

import com.b2win.projectbowl.exception.BusinessLogicException;
import com.b2win.projectbowl.member.entity.Member;
import com.b2win.projectbowl.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    void createMember() {
        Member member = Member.builder()
                .name("공희배")
                .birthDate(LocalDate.of(1997, 6, 1))
                .gender(Member.Gender.MALE)
                .id("Qwer1234")
                .password("Password")
                .email("test@naver.com")
                .build();

        given(memberRepository.findByUserId(Mockito.any())).willReturn(Optional.of(member));
        assertThrows(BusinessLogicException.class, () -> memberService.createMember(member));
    }

}
