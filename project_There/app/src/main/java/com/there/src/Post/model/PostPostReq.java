package com.there.src.Post.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PostPostReq {

    private int userIdx;
    private int postIdx;
    private String content;
    private String imgUrl;

}
