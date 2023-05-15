package com.example.firstproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostViewModel {
    private Long id;

    private String content;

    private LocalDateTime created_at;

    private List<String> photoUrls;

}
