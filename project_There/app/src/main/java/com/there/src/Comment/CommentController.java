package com.there.src.Comment;

import com.there.config.BaseException;
import com.there.config.BaseResponse;
import com.there.src.Comment.model.GetCommentRes;
import com.there.src.Comment.model.PostCommentReq;
import com.there.src.Comment.model.PostCommentRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final CommentProvider CommentProvider;
    private final CommentService CommentService;

    @Autowired
    public CommentController(CommentProvider CommentProvider, CommentService CommentService) {
        this.CommentProvider = CommentProvider;
        this.CommentService = CommentService;
    }

    // 댓글 조회
    @ResponseBody
    @GetMapping("/{postIdx}")
    public BaseResponse<List<GetCommentRes>> getComment (@PathVariable("postIdx")int postIdx){
        try{

            List<GetCommentRes> getComments = CommentProvider.retrieveComment(postIdx);
            return new BaseResponse<>(getComments);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    // 댓글 생성
    @ResponseBody
    @PostMapping("")
    public BaseResponse<PostCommentRes> createComment
    (@RequestBody PostCommentReq postCommentReq) {

        try {
            PostCommentRes postCommentRes = CommentService.createComment
                    (postCommentReq.getPostIdx(), postCommentReq.getUserIdx(), postCommentReq.getContent());
            return new BaseResponse<>(postCommentRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}

