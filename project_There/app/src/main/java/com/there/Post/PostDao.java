package com.there.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class PostDao {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 게시글 리스트 조회
    public List<GetPostsRes> selectPosts(int userid){
        String selectUserPostsQuery = "select * from post where postid = ?";
        int selectUserPostsParam = userid;

        return this.jdbcTemplate.queryForObject(selectUserPostsQuery,
                (rs, rowNum) -> new GetPostsRes(
                        rs.getInt("postid"),
                        rs.getString("imgsrc"),
                        rs.getString("content"),
                        rs.getString("created_at"),
                        rs.getString("status"),
                        rs.getString("userid")),
                selectUserPostsParam)
                ;



    }
}
