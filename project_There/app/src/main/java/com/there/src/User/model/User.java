package com.there.src.User.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private int userid;
    private String nickname;
    private String email;
    private String name;
    private String sex;
    private String birth;
    private String status;


}
