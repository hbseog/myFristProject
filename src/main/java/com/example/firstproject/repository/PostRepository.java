package com.example.firstproject.repository;

import com.example.firstproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUserIdOrderByCreatedAtDesc(Long userId);
    Optional<Post> findById(Long Id);
//    @Query("SELECT Post p FROM p join WHERE p.user_id =: user")
//    List
//    Page<Post> findByUserId(Long userId, Pageable pageable);
//    @Query("SELECT p FROM Post p WHERE p.user_id = :id")
//    List<Post> findByUserId(@Param("id") Long id);
//    @Query("SELECT p FROM Post p ORDER BY p.created_at DESC")
//    Page<Post> findLatestPosts(Pageable pageable);
    // 최근 게시된 게시글을 가져오는 쿼리
//    List<Post> findByPostIds(List<Long> postIds, Pageable pageable);

//    @Query(value = "", nativeQuery = true)
//    List<Post> findAllByUserId
}
