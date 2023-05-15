package com.example.firstproject.mapper;

import com.example.firstproject.entity.Image;
import com.example.firstproject.entity.Post;
import com.example.firstproject.model.PostViewModel;
import com.example.firstproject.model.TimelineViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TimelineMapper {
    public static TimelineViewModel map(List<Post> posts, List<Image> images) {
        TimelineViewModel viewModel = new TimelineViewModel();

        List<PostViewModel> postViewModels = new ArrayList<>();
        for (Post post : posts) {
            PostViewModel postViewModel = new PostViewModel();

            postViewModel.setId(post.getId());
            postViewModel.setContent(post.getContent());
            postViewModel.setCreated_at(post.getCreated_at());

            // 연관된 이미지들을 가져오기
            List<String> imageUrls = images.stream()
                    .filter(image -> image.getPost().getId().equals(post.getId()))
                    .map(Image::getImagePath)
                    .collect(Collectors.toList());

            postViewModel.setPhotoUrls(imageUrls);

            postViewModels.add(postViewModel);
        }

        viewModel.setPosts(postViewModels);
        return viewModel;
    }
}