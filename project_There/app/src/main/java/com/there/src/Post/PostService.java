package com.there.src.Post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {


        final Logger logger = LoggerFactory.getLogger(this.getClass());

        private final PostDao postDao;
        private final PostProvider postProvider;


        @Autowired
        public PostService(PostDao postDao, PostProvider postProvider) {
            this.postDao = postDao;
            this.postProvider = postProvider;

        }

}
