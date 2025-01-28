package com.example.shvlog.repository.post;

import com.example.shvlog.domain.Post;
import com.example.shvlog.request.post.PostSearch;
import java.util.List;

public interface PostRepositoryCustom {

    List<Post> getList(PostSearch postSearch);
}
