package com.there.src.Comment;

import com.there.src.Comment.model.GetCommentRes;
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
    public List<GetCommentRes> selectComments(int postIdx) {

        String selectPostCommentsQuery = "select nickName, profileImgUrl, content, created_at\n" +
                "from Comment c join User as u on u.userIdx = c.userIdx\n" +
                "where c.postidx = ?;";
        int selectPostCommentsParams = postIdx;

        return this.jdbcTemplate.query(selectPostCommentsQuery, (rs, rowNum) -> new GetCommentRes(
                rs.getString("nickName"),
                rs.getString("profileImgUrl"),
                rs.getString("content"),
                rs.getString("created_at")
        ), selectPostCommentsParams);
    }
}
