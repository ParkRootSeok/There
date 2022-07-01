package com.there.User.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "post")
@AllArgsConstructor
public class post {

    private int postid;
    private String imgsrc;
    private String content;
    private String created_at;
    private String sex;
    private String birth;
    private String status;

}
