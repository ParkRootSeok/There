package com.there.User.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Table;

@Data
@Table(name = "comment")
@AllArgsConstructor
public class comment {
    private int commentid;
    private String content;
    private String created_at;
    private String status;
}
