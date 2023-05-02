package com.example.firstproject.dto;

import com.example.firstproject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberDto {
    private String name;
    private String email;
    private String pass;
    private String confirm_pass;
    private String birth;
    private String phone;
    public Member memberEntity(){
        return new Member(name,email,pass,confirm_pass,birth,phone);
    }
}
