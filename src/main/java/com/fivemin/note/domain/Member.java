package com.fivemin.note.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fivemin.note.Dto.MemberForm;
import com.fivemin.note.Dto.MemberResponse;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String email;

    private String pw;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<UniqueDay> uniqueDays = new ArrayList<>();

    public Member(MemberForm memberForm) {  // 생성자
        // this.id = memberForm.getId(); // db에서 자동으로 생성되기 때문에 memberform에서 제외해야함.
        this.name = memberForm.getName();
        this.email= memberForm.getEmail();
        this.pw=memberForm.getPw();
    }

    public MemberResponse toMemberResponse() {
        return MemberResponse.builder()
                .id(id)
                .name(name)
                .build();
    }
}
