package com.example.firstproject.repository;

import com.example.firstproject.entity.Member;
import com.example.firstproject.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
