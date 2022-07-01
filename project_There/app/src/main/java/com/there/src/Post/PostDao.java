package com.there.src.Post;

import com.there.src.Post.model.Post;
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

    // 게시글 조회
    public Post selectPostInfo(int postid){
        String selectInfoPostQuery = "select * from post where postid = ?";
        int selectPostsParam = postid;

        return this.jdbcTemplate.queryForObject(selectInfoPostQuery,
                (rs, rowNum) -> new Post(
                        rs.getInt("postid"),
                        rs.getString("imgsrc"),
                        rs.getString("content"),
                        rs.getString("created_at"),
                        rs.getString("status"),
                        rs.getInt("userid")),
                selectPostsParam);
    }
    public static void main(String[] args){
        PostDao postDao = new PostDao();
        Post post = postDao.selectPostInfo(1);

        System.out.println(post.getPostid());
    }
}
