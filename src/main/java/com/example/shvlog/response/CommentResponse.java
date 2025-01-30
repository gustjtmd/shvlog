package com.example.shvlog.response;

import com.example.shvlog.domain.Comment;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class CommentResponse {
    private final Long id;
    private final String author;
    private final String content;
    private final LocalDateTime createdAt;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.author = comment.getAuthor();
        this.content = comment.getContent();
        this.createdAt = comment.getRegDate();
    }
}


