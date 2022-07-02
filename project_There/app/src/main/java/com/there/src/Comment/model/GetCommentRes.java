package com.there.src.Comment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetCommentRes {

    private String nickName;
    private String profileImgUrl;
    private String content;
    private String created_at;

}
