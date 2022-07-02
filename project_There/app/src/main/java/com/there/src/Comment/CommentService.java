package com.there.src.Comment;

import com.there.config.BaseException;
import com.there.config.BaseResponseStatus;
import com.there.src.Comment.model.PostCommentRes;
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

    public PostCommentRes createComment(int postIdx, int userIdx, String content) throws BaseException {
        try {
            int commentIdx = CommentDao.insertComment(postIdx, userIdx, content);
            return new PostCommentRes(commentIdx);
        } catch (Exception exception) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }

}
