package com.fivemin.note.service;

import com.fivemin.note.domain.Member;
import com.fivemin.note.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private Long memberId;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Member member) {

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    private List<org.aspectj.weaver.Member> findMembers() {
        return memberRepository.findAll();
    }

    // 회원 일부 조회
    private Member findOne(Long memberId) {
        this.memberId = memberId;
        return (Member) memberRepository.findOne(memberId);
    }

}
