package com.there.src.Comment;

import com.there.config.BaseException;
import com.there.config.BaseResponseStatus;
import com.there.src.Comment.model.PostCommentsReq;
import com.there.src.Comment.model.PostCommentsRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/comment")
public class CommentService {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CommentDao CommentDao;
    private final CommentProvider CommentProvider;

    @Autowired
    public CommentService(CommentDao CommentDao, CommentProvider CommentProvider) {
        this.CommentDao = CommentDao;
        this.CommentProvider = CommentProvider;
    }

    public PostCommentsRes createComment(int userIdx, int postIdx, String content) throws BaseException {
        try {
            CommentDao.insertComment(userIdx, postIdx, content);
            return new PostCommentsRes(userIdx, postIdx, content);
        } catch (Exception exception) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }

}
