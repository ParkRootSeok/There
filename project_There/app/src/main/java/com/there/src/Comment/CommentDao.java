package com.there.src.Comment;

import com.there.src.Comment.model.GetCommentRes;
import com.there.src.Comment.model.PostCommentReq;
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
    public int insertComment(int postIdx, int UserIdx, PostCommentReq postCommentReq) {

        String insertCommentQuery = "INSERT INTO Comment(postIdx, userIdx, content) valuse(postIdx,userIdx,?)";
        String insertCommentParam = postCommentReq.getContent();

        return this.jdbcTemplate.update(insertCommentQuery, insertCommentParam);
    }

    // 댓글 조회
    public List<GetCommentRes> selectComments(int postidx, int useridx) {

        String selectCommentsQuery = "select u.nickname, c.content" +
                                     "from Comment c, User u " +
                                     "where c.postidx = ? and c.useridx = ? and u.useridx = ?";
        Object[] selectCommentsParams = new Object[]{postidx, useridx, useridx};
        return this.jdbcTemplate.query(selectCommentsQuery, (rs, rowNum) -> new GetCommentRes(
                rs.getString("nickname"),
                rs.getString("content")
        ), selectCommentsParams);

    }

}
