package com.example.firstproject.model;

import java.util.List;

public class TimelineViewModel {
    private List<PostViewModel> posts;

    public List<PostViewModel> getPosts() {
        return posts;
    }

    public void setPosts(List<PostViewModel> posts) {
        this.posts = posts;
    }
}
