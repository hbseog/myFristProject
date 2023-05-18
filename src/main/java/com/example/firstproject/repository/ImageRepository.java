package com.example.firstproject.repository;

import com.example.firstproject.entity.Image;
import com.example.firstproject.entity.Member;
import com.example.firstproject.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image,Long> {
    List<Image>findByPost(Post post);
}
