package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Entity
@Table(name = "USER_CHECK")

public class User {
    @Id
    @Column
    private String email;
    @Column
    private String psw;

    public User() {
    }
}

