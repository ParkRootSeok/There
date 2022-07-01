package com.there.src.User.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetUserInfoRes {

    private int userId;
    private String profileImgUrl;
    private String name;
    private String nickName;
    private String introduction;

}
