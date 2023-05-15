package com.example.firstproject.controller;

import com.example.firstproject.entity.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice()
public class UserControllerAdvice {

    @ModelAttribute("username")
    public String addUserNameToModel(HttpSession session) {
        Member user = (Member) session.getAttribute("user");
        if (user == null) {
            return null;
        } else {
            return user.getName();
        }
    }
    @ModelAttribute("loginstatus")
    public String loginStatusModel(HttpSession session) {
        Member user = (Member) session.getAttribute("user");
        if (user == null) {
            return null;
        } else {
            return user.getLoginstatus();
        }
    }

    @ModelAttribute("id")
    public Long idModel(HttpSession session) {
        Member user = (Member) session.getAttribute("user");
        if (user == null) {
            return null;
        } else {
            return user.getId();
        }
    }
}