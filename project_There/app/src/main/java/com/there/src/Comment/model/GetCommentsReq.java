package com.there.src.Comment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetCommentsReq {

    private int userIdx;
    private String content;

}
