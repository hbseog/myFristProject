package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Table(name = "USER_MEMBER")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR2",
        sequenceName = "MEMBER_SEQUENCE",
        allocationSize = 1
)
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
    @Column(name = "CONFIRM_PASS")
    private String confirm_pass;
    @Column(name = "BRITH")
    private String birth;
    @Column(name = "PHONE")
    private String phone;

    public Member(String name, String email,String pass, String confirm_pass, String birth, String phone){
        this.name=name;
        this.email=email;
        this.pass=pass;
        this.confirm_pass=confirm_pass;
        this.birth=birth;
        this.phone=phone;
    }

    public Member() {

    }
}