package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(name = "USER_MEMBER")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR2",
        sequenceName = "MEMBER_SEQUENCE",
        allocationSize = 1
)
@AllArgsConstructor

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR2")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASS")
    private String pass;

    @Column(name = "loginstatus")
    private String loginstatus;

    @OneToMany(mappedBy = "member",cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Follower> followers;
    @OneToMany(mappedBy = "member",cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Following> followings;

    public Member(String name, String email, String pass) {
        this.name = name;
        this.email = email;
        this.pass = pass;

    }
//    public void addFollower(Follower follower) {
//        if (followers == null) {
//            followers = new ArrayList<>();
//        }
//        followers.add(follower);
//        follower.setMember(this);
//    }
//    public void addFollowing(Following following) {
//        if (followings == null) {
//            followings = new ArrayList<>();
//        }
//        followings.add(following);
//        following.setMember(this);
//    }


    public Member() {
    }
}
