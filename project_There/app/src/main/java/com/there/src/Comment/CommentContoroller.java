package com.there.src.Comment;

import com.there.config.BaseException;
import com.there.config.BaseResponse;
import com.there.src.Comment.model.PostCommentReq;
import com.there.src.Comment.model.PostCommentRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts/comments")
public class CommentContoroller {

    final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final CommentProvider CommentProvider;
    private final CommentService CommentService;

    @Autowired
    public CommentContoroller(CommentProvider CommentProvider, CommentService CommentService){
        this.CommentProvider = CommentProvider;
        this.CommentService = CommentService;
    }

    // 댓글 생성
    @ResponseBody
    @PostMapping("/{userIdx}/{postidx}")
    public BaseResponse<PostCommentRes> createComment
    (@PathVariable("useridx")int userIdx, @PathVariable("postIdx")int postIdx, @RequestBody PostCommentReq postCommentReq) {

        try {
            PostCommentRes postCommentRes = CommentService.createComment(userIdx, postIdx, postCommentReq);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }




    }

}
