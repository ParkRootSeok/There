package com.there.src.Post;

import com.there.config.BaseException;
import com.there.src.Post.model.GetPostRes;
import com.there.src.Post.model.PostPostReq;
import com.there.src.Post.model.PostPostRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.there.config.BaseResponseStatus.DATABASE_ERROR;
import static com.there.config.BaseResponseStatus.USERS_EMPTY_USER_ID;

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

    // !-- ethan
    // 게시물 생성
    public PostPostRes createPost(int userIdx, PostPostReq postPostReq) throws BaseException {

        try {

            // 게시물 DB에서 생성시 게시물 식별자 Dao에서 가져옴
            int postIdx = postDao.insertPost(userIdx, postPostReq.getContent());

            // 게시물 이미지 삽입
            postDao.insertPostImg(postIdx, postPostReq.getImgUrl());

            return new PostPostRes(postIdx);
        } catch (Exception exception) {

            throw new BaseException(DATABASE_ERROR);

        }


    }
}
