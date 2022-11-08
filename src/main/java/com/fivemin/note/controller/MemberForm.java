package com.fivemin.note.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {

    private Long id;

    private String nickname;

    private String email;

    private String pw;
}
