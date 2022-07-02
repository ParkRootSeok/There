package com.there.src.Comment;

import com.there.config.BaseException;
import com.there.src.Comment.model.GetCommentsRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.there.config.BaseResponseStatus.*;

@Service
public class CommentProvider {

    private final CommentDao CommentDao;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CommentProvider(CommentDao CommentDao) {
        this.CommentDao = CommentDao;
    }

    public List<GetCommentsRes> retrieveComments(int userIdx, int postIdx) throws BaseException {

        try {
            List<GetCommentsRes> getComments = CommentDao.selectComments(userIdx, postIdx);
            return getComments;
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }

    }

}
