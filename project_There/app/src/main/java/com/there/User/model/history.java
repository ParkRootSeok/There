package com.there.User.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
class history {

    private int historyid;
    private int postid;
    private String title;
    private String imgsrc;
    private String content;
    private String created_at;
    private String status;
}
