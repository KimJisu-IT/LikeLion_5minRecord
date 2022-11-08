package com.fivemin.note.service;

import com.fivemin.note.domain.Member;
import com.fivemin.note.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public Long join(Member member) {   // shift + 위아래 키, numLock
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findAllByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 회원 일부 조회
    private Member findOne(Long memberId) {
        this.memberId = memberId;
        return (Member) memberRepository.findById(memberId).get();      // 받아온 건 optional, 줘야하는 건 member/ 알맹이인 member를 뽑아내려면 .get()을 사용해야 한다.
    }

    public void login(String email, String pw) {
        Optional<Member> member = memberRepository.findByEmailAndPw(email, pw);
        if (member.isPresent()) {

        } else {
            throw new IllegalArgumentException("이메일과 비밀번호가 일치하지 않습니다.");
        }
    }
}
