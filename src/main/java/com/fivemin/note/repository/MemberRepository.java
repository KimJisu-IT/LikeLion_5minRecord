package com.fivemin.note.repository;

import com.fivemin.note.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// DB에 Data를 넣고 빼기
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByName(String name);  // 한 개의 이름을 찾고 싶음: Optional<Today> findByMood(String mood);
    // List<UniqueDay> findAllByText(String text);

    Optional<Member> findByEmailAndPw(String email, String pw);
}