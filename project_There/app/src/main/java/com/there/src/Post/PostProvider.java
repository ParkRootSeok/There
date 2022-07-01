package com.there.src.Post;

import com.there.config.BaseException;

import com.there.src.Post.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.there.config.BaseResponseStatus.*;
@Service
public class PostProvider {
    private final PostDao postDao;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public PostProvider(PostDao postDao) {
        this.postDao = postDao;
    }

    // 유저의 게시물인지 확인
    /*public int checkUserPostExist(int userIdx, int postIdx) throws BaseExeption, BaseException {
        try {
            return postDao.checkUserPostExist(userIdx, postIdx);
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }*/
}
