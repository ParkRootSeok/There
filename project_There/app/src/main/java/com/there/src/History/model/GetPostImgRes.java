package com.there.src.History.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetPostImgRes {
    private int pictureIdx;
    private int postIdx;
    private String imgUrl;
    private String content;
    private String create_At;
    private String status;
}
