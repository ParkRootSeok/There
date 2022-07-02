package com.there.src.Post;

import com.there.config.BaseException;

import com.there.src.Post.model.GetPostRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.there.config.BaseResponseStatus.*;
@Service
public class PostProvider {
    private final PostDao postDao;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public PostProvider(PostDao postDao) {

        this.postDao = postDao;
    }


    // 게시글
    public GetPostRes retrievePost(int postIdx) throws BaseException{

        try{
            GetPostRes getPostRes = postDao.selectPost(postIdx);

            return getPostRes;
        } catch(Exception exception) {
            System.out.println(exception);
            throw new BaseException(DATABASE_ERROR);
        }
    }

}
