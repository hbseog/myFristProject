package com.example.firstproject.DTO;

import com.example.firstproject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class memberDto {
    private final String name;
    private final String email;
    private final String pass;
    private final String confirm_pass;
    private final String birth;
    private final String phone;
    public Member memberEntity(){
        return new Member(name,email,pass,confirm_pass,birth,phone);
    }
}
