package com.there.src.User.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetUserInfoRes {

    private int userid;
    private String profileImgUrl;
    private String name;
    private String nickname;
    private String introduction;

}
