package com.example.shvlog.service;

import com.example.shvlog.domain.Comment;
import com.example.shvlog.domain.Post;
import com.example.shvlog.exception.InvalidPassword;
import com.example.shvlog.exception.PostNotFound;
import com.example.shvlog.exception.CommentNotFound;
import com.example.shvlog.repository.comment.CommentRepository;
import com.example.shvlog.repository.post.PostRepository;
import com.example.shvlog.request.comment.CommentCreate;
import com.example.shvlog.request.comment.CommentDelete;
import com.example.shvlog.request.comment.CommentSearch;
import com.example.shvlog.request.post.PostSearch;
import com.example.shvlog.response.CommentResponse;
import com.example.shvlog.response.PagingResponse;
import com.example.shvlog.response.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void write(Long postId, CommentCreate request) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFound::new);

        String encryptedPassword = passwordEncoder.encode(request.getPassword());

        Comment comment = Comment.builder()
                .author(request.getAuthor())
                .password(encryptedPassword)
                .content(request.getContent())
                .build();

        post.addComment(comment);
    }

    public void delete(Long commentId, CommentDelete request) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFound::new);

        String encryptedPassword = comment.getPassword();
        if (!passwordEncoder.matches(request.getPassword(), encryptedPassword)) {
            throw new InvalidPassword();
        }

        commentRepository.delete(comment);
    }

    public PagingResponse<CommentResponse> getList(CommentSearch commentSearch) {
        Page<Comment> commentPage = commentRepository.getList(commentSearch);
        PagingResponse<CommentResponse> commentList = new PagingResponse<>(commentPage, CommentResponse.class);
        return commentList;
    }

}

