package com.there.src.Post.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetPostRes {
    private int postIdx;
    private String imgUrl;
    private String content;
    private String create_At;
    private String status;
    private int userIdx;

}
