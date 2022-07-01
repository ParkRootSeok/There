package com.there.src.Comment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {

    private int commentIdx;
    private int postIdx;
    private int userIdx;
    private String content;
    private String created_at;
    private String status;


}
