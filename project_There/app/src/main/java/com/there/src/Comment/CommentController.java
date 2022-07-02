package com.there.src.Comment;

import com.there.config.BaseException;
import com.there.config.BaseResponse;
import com.there.src.Comment.model.GetCommentsRes;
import com.there.src.Comment.model.PostCommentsReq;
import com.there.src.Comment.model.PostCommentsRes;
import com.there.src.Post.model.PostPostReq;
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
    @GetMapping("/{userIdx}/{postIdx}")
    public BaseResponse<List<GetCommentsRes>> getComments
                                            (@PathVariable("userIdx")int userIdx, @PathVariable("postIdx")int postIdx){
        try{

            List<GetCommentsRes> getComments = CommentProvider.retrieveComments(userIdx, postIdx);
            return new BaseResponse<>(getComments);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    // 댓글 생성
    @ResponseBody
    @PostMapping("/{userIdx}/{postIdx}")
    public BaseResponse<PostCommentsRes> createComment
    (@PathVariable("userIdx") int userIdx, @PathVariable("postIdx") int postIdx, @RequestBody PostCommentsReq postCommentsReq) {

        try {
            PostCommentsRes postCommentsRes = CommentService.createComment(userIdx, postIdx, postCommentsReq.getContent());
            return new BaseResponse<>(postCommentsRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
//=======
    }

}

