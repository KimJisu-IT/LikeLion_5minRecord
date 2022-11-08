package com.fivemin.note.domain;

import javax.persistence.*;

public class TodayCheck {
    @Id
    @GeneratedValue
    @Column(name = "today_check_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "today_id")
    private Today today;

    private Long satis;

    public String mood;

    public String todaydo;

    public String tomorrow;

}
