package com.example.firstproject.repository;

import com.example.firstproject.entity.Member;
import com.example.firstproject.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member,Long> {

}