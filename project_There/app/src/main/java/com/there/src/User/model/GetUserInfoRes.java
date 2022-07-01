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
    private String name;
    private String profileImgUrl;
    private String Info;

}
