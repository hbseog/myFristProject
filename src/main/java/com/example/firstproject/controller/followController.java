package com.example.firstproject.controller;

import com.example.firstproject.DTO.memberDto;
//import com.example.firstproject.entity.Follower;
//import com.example.firstproject.entity.Following;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.FollowerRepository;
import com.example.firstproject.repository.FollowingRepository;
import com.example.firstproject.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class followController {
    @Autowired
    UserControllerAdvice a;
    @Autowired
    FollowerRepository followerRepository;
    @Autowired
    FollowingRepository followingRepository;
    @Autowired
    MemberRepository memberRepository;

    @PostMapping("/follow")
    public String follow(@RequestParam Long id, HttpSession session) {
        //다시 시작

        
        
        
        
        
        
        
        
        
        
        
        
        
//        log.info(id.toString());
//        //팔로우를 누른 사용자
//        Member members = memberRepository.findAllById(a.idModel(session));
//        log.info("팔로우를 누른 사용자" + members);
//        //팔로우를 누름 당한 사용자
//        Member user = memberRepository.findAllById(id);
//        log.info("팔로우를 눌린 사용자" + user);

//        Following following = followingRepository.findById(a.idModel(session));
        //팔로우를 누름 당한 사용자를 팔로잉에 저장하기위해 Following객체화
//        List<Following> following = followingRepository.findByMember(user);
//        log.info("팔로우를 눌린 사용자 리스트화" + following.get(0));

        //팔로우를 누른 사용자를 팔로워에 저장하기위해 Follower객체화
//        List<Follower> follower = followerRepository.findByMember(members);

//        List<Follower> followers = new ArrayList<>();
//        List<Following> followings = new ArrayList<>();
//        Follower follower = new Follower(user, members.getId());
//        followers.add(follower);
//        Following following = new Following(members, user.getId());
//        followings.add(following);
//        log.info("팔로워"+followers.toString());
//        log.info("팔로잉"+followings.toString());

//        log.info("팔로우를 누른 사용자 리스트화" + follower.get(0));
//        members.setFollowers(follower);
//        user.setFollowings(following);
//        user.setFollowers(followers);
//        members.setFollowings(followings);
//        memberRepository.save(members);

//        followerRepository.save(follower);
//        followingRepository.save(following);
//        followerRepository.save(follower.get(0));
//        followingRepository.save(following.get(0));
//        session.getId();
        return "redirect:searchView";
    }
}
