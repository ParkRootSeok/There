package com.there.src.Comment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetCommentRes {

    private String nickname;
    private String content;

}
