package com.example.firstproject.service;

import com.example.firstproject.entity.Image;
import com.example.firstproject.entity.Post;
import com.example.firstproject.repository.ImageRepository;
import com.example.firstproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimelineService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ImageRepository imageRepository;

    public List<Post> getPosts(int page) {
        // 게시글 정보 조회
        PageRequest pageable = PageRequest.of(page, 10, Sort.by("created_at").descending());
        Page<Post> postsPage = postRepository.findLatestPosts(pageable);
        return postsPage.getContent();
    }
    // 이미지 정보 가져오기
    public List<Image> getImages() {
        return imageRepository.findAll();
    }

}
