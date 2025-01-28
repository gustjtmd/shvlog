package com.example.shvlog.repository.post;

import com.example.shvlog.domain.Post;
import com.example.shvlog.request.post.PostSearch;
import java.util.List;
import org.springframework.data.domain.Page;

public interface PostRepositoryCustom {

    Page<Post> getList(PostSearch postSearch);
}
