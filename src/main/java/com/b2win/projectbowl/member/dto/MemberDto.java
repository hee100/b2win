package com.b2win.projectbowl.member.dto;

import com.b2win.projectbowl.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;

public class MemberDto {
    @Getter
    @NoArgsConstructor
    public static class Post {
        @Pattern(regexp = "^[ㄱ-ㅎ가-힣]{2,20}$", message = "이름을 입력해주십시오.")
        @NotBlank(message = "이름은 필수 입력 값입니다.")
        private String name;

        @Past(message = "생년월일은 과거의 날짜여야 합니다.")
        private LocalDate birthDate;

        @NotNull(message = "성별은 필수 입력 값입니다.")
        private Member.Gender gender;

        @Pattern(regexp = "^[a-zA-Z0-9]{5,20}$", message = "Id는 5~20자의 영문 대 소문자와 숫자로만 구성되어야 합니다.")
        @NotBlank(message = "Id는 필수 입력 값입니다.")
        private String id;

        @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
        @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
        private String password;

        @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다.")
        @Email
        private String email;

    }




}
