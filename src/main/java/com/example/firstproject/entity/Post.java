package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

import java.awt.*;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR3",
        sequenceName = "POST_SEQUENCE",
        allocationSize = 1
)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    public Post() {
    }
    public Post(String content) {
        this.content = content;
    }
}
