package com.there.src.Comment;

import com.there.src.Comment.model.GetCommentsRes;
import com.there.src.Comment.model.PostCommentsReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CommentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 댓글 생성
    public int insertComment(int postIdx, int userIdx, String content) {

        String insertCommentQuery = "INSERT INTO Comment(postIdx, userIdx, content) VALUES (?, ?, ?);";
        Object[] insertCommentParam = new Object[]{postIdx, userIdx, content};

        return this.jdbcTemplate.update(insertCommentQuery, insertCommentParam);
    }

    // 댓글 조회
    public List<GetCommentsRes> selectComments(int userIdx, int postIdx) {

        String selectPostCommentsQuery = "SELECT u.nickName, c.content FROM Comment c, User u WHERE c.postIdx = ? and u.userIdx = ? and c.userIdx = ?;";
        Object[] selectPostCommentsParams = new Object[]{postIdx, userIdx, userIdx};

        return this.jdbcTemplate.query(selectPostCommentsQuery, (rs, rowNum) -> new GetCommentsRes(
                rs.getString("nickName"),
                rs.getString("content")
        ), selectPostCommentsParams);

    }

}
