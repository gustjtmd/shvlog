package com.example.shvlog.controller;

import com.example.shvlog.request.comment.CommentCreate;
import com.example.shvlog.request.comment.CommentDelete;
import com.example.shvlog.request.comment.CommentSearch;
import com.example.shvlog.response.CommentResponse;
import com.example.shvlog.response.PagingResponse;
import com.example.shvlog.response.PostResponse;
import com.example.shvlog.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/api/posts/{postId}/comments")
    public void write(@PathVariable Long postId, @RequestBody @Valid CommentCreate request) {
        commentService.write(postId, request);
    }

    @PostMapping("/api/comments/{commentId}/delete")
    public void delete(@PathVariable Long commentId, @RequestBody @Valid CommentDelete request) {
        commentService.delete(commentId, request);
    }

    @GetMapping("/api/posts/{postId}/comments")
    public PagingResponse<CommentResponse> getList(@PathVariable Long postId, @ModelAttribute CommentSearch commentSearch) {
        return commentService.getList(commentSearch);
    }

}
