package com.example.firstproject.repository;
import com.example.firstproject.entity.Member;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    List<Member> findByName(String name);
    Member findAllById(Long id);



    @Modifying
    @Query("UPDATE Member m SET m.loginstatus = :status WHERE m.email = :email")
    void setLoginstatus(@Param("email") String email, @Param("status") boolean status);

}
