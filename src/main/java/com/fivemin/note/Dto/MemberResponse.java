package com.fivemin.note.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class MemberResponse {
    private Long id;
    private String name;
}


