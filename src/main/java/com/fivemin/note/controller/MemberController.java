package com.fivemin.note.controller;

import com.fivemin.note.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Address;
import org.aspectj.weaver.Member;
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

    @PostMapping("/members/signup")
    public String create(MemberForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Member member = new Member();
        member.setName(member.getName());

        memberService.join((com.fivemin.note.domain.Member) member);
        return "redirect:/";
    }

    @GetMapping("/members/login")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
