package com.b2win.projectbowl.member.controller;

import com.b2win.projectbowl.member.dto.MemberDto;
import com.b2win.projectbowl.member.entity.Member;
import com.b2win.projectbowl.member.service.MemberService;
import com.b2win.projectbowl.utils.UriCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api")
@Validated
@RequiredArgsConstructor
public class MemberController {
    private final static String MEMBER_DEFAULT_URL = "/members";
    private final MemberService memberService;

    @PostMapping("/member/save")
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post requestBody) {
        Member member = Member.fromDto(requestBody);
        Member createdMember = memberService.createMember(member);
        URI location = UriCreator.createUri(MEMBER_DEFAULT_URL, createdMember.getMemberId());

        return ResponseEntity.created(location).body("회원가입에 성공했습니다.");
    }

}
