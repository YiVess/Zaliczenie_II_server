package com.example.tasty.post.comment;

import com.example.tasty.service.HibernateAbstractService;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends HibernateAbstractService<Comment,Integer> {
    public CommentService() {
        super(Comment.class);
    }
}
