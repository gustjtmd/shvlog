package com.example.shvlog.repository.comment;

import com.example.shvlog.domain.Comment;
import com.example.shvlog.request.comment.CommentSearch;
import org.springframework.data.domain.Page;

public interface CommentRepositoryCustom {

    Page<Comment> getList(CommentSearch commentSearch);

}
