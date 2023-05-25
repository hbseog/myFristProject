package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "memberid", insertable = false, updatable = false)
    private Member member;

    @Column(name = "followerId")
    private Long followerId;

    public Follower(Long followerId){
        this.followerId = followerId;
    }

    public Follower() {

    }


}
