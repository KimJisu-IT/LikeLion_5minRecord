package com.fivemin.note.controller;

import com.fivemin.note.Dto.LoginRequest;
import com.fivemin.note.Dto.MemberForm;
import com.fivemin.note.Dto.MemberResponse;
import com.fivemin.note.service.MemberService;
import lombok.RequiredArgsConstructor;
import com.fivemin.note.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members/signup")     // 회원가입
    public MemberResponse create(MemberForm form) {

        Member member = new Member(form);

        memberService.join(member);     // controller -> service
        return member.toMemberResponse();  //ctrl + alt + v
    }

    @GetMapping("/members/login")
    public MemberResponse login(LoginRequest loginRequest) {
        Member member = memberService.login(loginRequest.getEmail(), loginRequest.getPw());
        return member.toMemberResponse();
    }

}
