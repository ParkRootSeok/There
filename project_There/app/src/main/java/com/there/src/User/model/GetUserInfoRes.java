package com.there.src.User.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetUserInfoRes {

    private int userIdx;
    private String nickName;
    private String email;
    private String profileImgUrl;
    private String Info;
    private String birth;
    private String status;
    private String sex;
    private String name;


}
