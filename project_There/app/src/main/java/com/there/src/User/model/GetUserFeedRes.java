package com.there.src.User.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetUserFeedRes {

    private GetUserInfoRes getUserInfo;
    private List<GetUserPostsRes> getUserPosts;

}