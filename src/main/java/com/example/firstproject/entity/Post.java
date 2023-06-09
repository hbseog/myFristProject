package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import java.awt.*;

@Entity
//@ToString
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

    @Column(nullable = true)
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Image> images;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "createdAt")
//    @OrderBy("createdAt ASC")
    private LocalDateTime createdAt;
    @PrePersist
    public void addDate(){
        this.createdAt = LocalDateTime.now();
    }

    public String getFormattedDatetime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분");
        return createdAt.format(formatter);
    }
    public Post() {
    }

    public Post(String content) {
        this.content = content;
    }
}
