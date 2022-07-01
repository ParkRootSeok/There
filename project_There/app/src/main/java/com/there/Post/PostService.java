package com.there.Post;

public class PostService {
    @Service
    public class PostService {
        final Logger logger = LoggerFactory.getLogger(this.getClass());

        private final PostDao postDao;
        private final PostProvider postProvider;
        private final JwtService jwtService;


        @Autowired
        public PostService(PostDao postDao, PostProvider postProvider, JwtService jwtService) {
            this.postDao = postDao;
            this.postProvider = postProvider;

        }
}
