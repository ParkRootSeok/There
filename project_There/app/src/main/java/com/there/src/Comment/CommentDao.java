package com.there.src.Comment;

import com.there.src.Comment.model.PostCommentReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CommentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 댓글 생성
    public int insertComment(int postIdx, int UserIdx, PostCommentReq postCommentReq) {

        String insertCommentQuery = "INSERT INTO Comment(postIdx, userIdx, content) valuse(postIdx,userIdx,?)";
        String insertCommentParam = postCommentReq.getContent();

        return this.jdbcTemplate.update(insertCommentQuery, insertCommentParam);
    }


}
