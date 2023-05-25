package com.example.firstproject.repository;

import com.example.firstproject.entity.Following;
import com.example.firstproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FollowingRepository extends JpaRepository<Following,Long> {
    Optional<Following> findById(Long id);
    List<Following> findByMember(Member member);

}
