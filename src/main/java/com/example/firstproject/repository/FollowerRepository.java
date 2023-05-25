package com.example.firstproject.repository;

import com.example.firstproject.entity.Follower;
import com.example.firstproject.entity.Following;
import com.example.firstproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FollowerRepository extends JpaRepository<Follower,Long> {
    List<Follower> findByMember(Member member);
}
