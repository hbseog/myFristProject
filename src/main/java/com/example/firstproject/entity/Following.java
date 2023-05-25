package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Following {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "memberid", insertable = false, updatable = false)
    private Member member;

    @Column(name = "followingId")
    private Long followingId;

    public Following(Long followingId){
        this.followingId = followingId;
    }

    public Following() {

    }
}
