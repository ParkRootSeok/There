package com.there.src.Post.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetPostImgRes {
     private int pictureIdx;
     private String imgUrl;
     private String content;

}
