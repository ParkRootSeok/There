package com.there.User.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class picture {

    private int pictureid;
    private String postid;
    private String imgsrc;
    private String content;
    private String created_at;
    private String status;

}
