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
//public class Following {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//
//    @ManyToOne
//    @JoinColumn(name = "memberid")
//    private Member member;
//
//    private Long followingId;
//
//    public Following(Member member, Long followingId) {
//        this.member = member;
//        this.followingId = followingId;
//    }
//
////    public Following(Long followingId){
////        this.followingId = followingId;
////    }
//
//}
