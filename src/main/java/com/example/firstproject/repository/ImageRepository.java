package com.example.firstproject.repository;

import com.example.firstproject.entity.Image;
import com.example.firstproject.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image,Long> {
}
