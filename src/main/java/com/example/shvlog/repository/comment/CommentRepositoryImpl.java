package com.example.shvlog.repository.comment;

import static com.example.shvlog.domain.QComment.comment;
import com.example.shvlog.domain.Comment;
import com.example.shvlog.domain.Post;
import com.example.shvlog.request.comment.CommentSearch;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Comment> getList(CommentSearch commentSearch) {
        long totalCount = jpaQueryFactory.select(comment.count())
                .from(comment)
                .fetchFirst();

        List<Comment> items = jpaQueryFactory.selectFrom(comment)
                .limit(commentSearch.getSize())
                .offset(commentSearch.getOffset())
                .orderBy(comment.id.asc())
                .fetch();

        return new PageImpl<>(items, commentSearch.getPageable(), totalCount);

    }
}
