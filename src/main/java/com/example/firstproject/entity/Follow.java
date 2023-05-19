package com.example.firstproject.entity;

import jakarta.persistence.*;

@Entity
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="following")
    private Member following;

    @ManyToOne
    @JoinColumn(name="follower")
    private Member follower;
}
