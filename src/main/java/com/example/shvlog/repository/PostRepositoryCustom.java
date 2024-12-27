package com.example.shvlog.repository;

import com.example.shvlog.domain.Post;
import com.example.shvlog.request.PostSearch;
import java.util.List;

public interface PostRepositoryCustom {
    List<Post> getList(PostSearch postSearch);

}
