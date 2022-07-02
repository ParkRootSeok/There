package com.there.src.History.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetHistoryRes {
    private int historyIdx;
    private int postIdx;
    private String title;
    private String imgUrl;
    private String content;
    private String created_At;
    private String status;

}
