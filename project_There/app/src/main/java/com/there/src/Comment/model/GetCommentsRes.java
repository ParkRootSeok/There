package com.there.src.Comment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetCommentsRes {

    private String nickname;
    private String content;

}
