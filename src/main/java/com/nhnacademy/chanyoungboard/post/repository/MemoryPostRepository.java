package com.nhnacademy.chanyoungboard.post.repository;

import com.nhnacademy.chanyoungboard.pagenation.Page;
import com.nhnacademy.chanyoungboard.post.domain.Post;
import com.nhnacademy.chanyoungboard.user.domain.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Slf4j
public class MemoryPostRepository implements PostRepository{

    private final ConcurrentMap<Long, Post> postMap = new ConcurrentHashMap<>();

    @Override
    public void register(Post post) {
        postMap.put(post.getId(),post);
    }

    @Override
    public void modify(Post post) {

    }

    @Override
    public Post remove(long id) {
        return null;
    }

    @Override
    public Post getPost(long id) {
        return postMap.get(id);
    }

    @Override
    public List<Post> getPosts() {
        return new ArrayList<>(postMap.values());
    }

    @Override
    public int getTotalCount() {
        return 0;
    }

    @Override
    public boolean existById(String id) {
        return false;
    }


    @Override
    public Page<Post> getPagedList(int page, int size) {
        return new Page<Post>() {
            @Override
            public int getPageNumber() {
                return page;
            }

            @Override
            public int getPageSize() {
                return size;
            }

            @Override
            public int getTotalPageCount() {
                return (int)Math.ceil( (getTotalCount()*1.0) /getPageSize());
            }

            @Override
            public long getTotalCount() {
                return postMap.size();
            }

            @Override
            public List<Post> getList() {
                List<Post> posts = postMap.values().stream()
                        .sorted(Comparator.comparing(Post::getCreatedAt).reversed())
                        .collect(Collectors.toList());

                int start = (getPageNumber()-1)*getPageSize();
                int end = start + getPageSize();

                if(end > getTotalCount()){
                    end = (int) getTotalCount();
                }

                log.info("totalCount:{}" + getTotalCount());
                log.info("post-page-start:{}",start);
                log.info("post-page-end:{}",end);

                return posts.subList(start,end);
            }
        };
    }


}
