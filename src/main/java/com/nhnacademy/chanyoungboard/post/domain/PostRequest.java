package com.nhnacademy.chanyoungboard.post.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostRequest {
    private long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;

    public PostRequest(long id, String title, String content, String writer, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
    }
}
