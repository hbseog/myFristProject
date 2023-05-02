package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@ToString
@Table(name = "MEMBER")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR2",
        sequenceName = "MEMBER_SEQUENCE",
        allocationSize = 1
)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR2")
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String pass;
    @Column
    private String confirm_pass;
    @Column
    private String birth;
    @Column
    private String phone;

    public Member(String name, String email,String pass, String confirm_pass, String birth, String phone){
        this.name=name;
        this.email=email;
        this.pass=pass;
        this.confirm_pass=confirm_pass;
        this.birth=birth;
        this.phone=phone;
    }
}
