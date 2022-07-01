package com.there.src.Comment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentProvider {

    private final CommentDao CommentDao;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CommentProvider(CommentDao CommentDao) {
        this.CommentDao = CommentDao;
    }
}
