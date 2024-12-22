package com.example.shvlog.repository;

import com.example.shvlog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {

}

