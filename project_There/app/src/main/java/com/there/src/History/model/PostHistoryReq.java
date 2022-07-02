package com.there.src.History.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PostHistoryReq {

    private int userIdx;
    private int postIdx;
    private String title;
    private String content;
    private String imgUrl;

}
