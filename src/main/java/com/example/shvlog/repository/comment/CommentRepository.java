package com.example.shvlog.repository.comment;

import com.example.shvlog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> , CommentRepositoryCustom{
}

