package com.nhnacademy.chanyoungboard.post.service;

import com.nhnacademy.chanyoungboard.pagenation.Page;
import com.nhnacademy.chanyoungboard.post.domain.Post;
import com.nhnacademy.chanyoungboard.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostService {

    private  final PostRepository postRepository;

    public Post getPost(long id){
        Post post = postRepository.getPost(id);
        if(Objects.isNull(post)){
            throw new RuntimeException();
        }

        return post;
    }

    public Page<Post> getPostList(int page, int size){
        return postRepository.getPagedList(page,size);
    }


}
