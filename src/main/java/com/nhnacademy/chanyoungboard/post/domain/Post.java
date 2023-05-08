package com.nhnacademy.chanyoungboard.post.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@ToString
public class Post {
    private long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;

    private Post(long id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdAt = LocalDateTime.now();
    }

    public static Post createpost(long id, String title, String content, String writer){

        return new Post(id,title,content,writer);
    }




}
