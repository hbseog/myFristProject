package com.example.firstproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class FollowDto {
    private final Long follower;
    private final Long Following;

    public FollowDto(Long follower, Long following) {
        this.follower = follower;
        this.Following = following;
    }
}
