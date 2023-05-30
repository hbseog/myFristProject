//package com.example.firstproject.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//public class Follower {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//
//    @ManyToOne
//    @JoinColumn(name = "memberid")
//    private Member member;
//
//    private Long followerId;
//
////    public Follower(Long followerId){
////        this.followerId = followerId;
////    }
////
//    public Follower(Member member,Long followerId) {
//        this.member = member;
//        this.followerId = followerId;
//
//    }
//}
//
