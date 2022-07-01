package com.there.src.Post;

import com.there.config.BaseException;
import com.there.config.BaseResponse;
import com.there.src.Post.model.PostPostReq;
import com.there.src.Post.model.PostPostRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final PostProvider postProvider;
    @Autowired
    private final PostService postService;

    public PostController(PostProvider postProvider, PostService postService){
        this.postProvider = postProvider;
        this.postService = postService;

    }

    /**
     * 게시물 생성 API
     * [POST] /posts
     *
     * @return BaseResponse<postPostRes>
     */

    @ResponseBody
    @PostMapping("")
    public BaseResponse<PostPostRes> createPost(@RequestBody PostPostReq postPostReq) {


        try {

            //int userIdxByJwt = jwtService.getUserIdx();

            PostPostRes postPostRes = postService.createPost(postPostReq.getUserIdx(), postPostReq);

            return new BaseResponse<>(postPostRes);

        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

}