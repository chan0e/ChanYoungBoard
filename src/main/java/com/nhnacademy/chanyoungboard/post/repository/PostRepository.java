package com.nhnacademy.chanyoungboard.post.repository;

import com.nhnacademy.chanyoungboard.pagenation.Page;
import com.nhnacademy.chanyoungboard.post.domain.Post;
import com.nhnacademy.chanyoungboard.user.domain.User;

import java.util.List;

public interface PostRepository {

    void register(Post post);
    void modify(Post post);
    Post remove(long id);

    Post getPost(long id);
    List<Post> getPosts();

//


    int getTotalCount();
    Page<Post> getPagedList(int page, int size);
    boolean existById(String id);

}
