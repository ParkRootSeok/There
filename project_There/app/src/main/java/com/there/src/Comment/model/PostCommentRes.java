package com.there.src.Comment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostCommentRes {

    private int postIdx;
    private int userIdx;
    private String content;

}
