package com.there.src.Post;

import com.there.src.Post.model.GetPostImgRes;
import com.there.src.Post.model.GetPostRes;
import com.there.src.Post.model.PostPostReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;


@Component
public class PostDao {

    private JdbcTemplate jdbcTemplate;
    private List<GetPostImgRes> getPostImgRes;


    @Autowired
    public void setDataSource(DataSource dataSource){

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 게시글 조회
    public GetPostRes selectPost(int postIdx){
        String selectPostQuery = "select * from Post where postIdx = ?";
        int selectPostsParam = postIdx;

        return this.jdbcTemplate.queryForObject(selectPostQuery,
                (rs, rowNum) -> new GetPostRes(
                        rs.getInt("postIdx"),
                        rs.getString("imgUrl"),
                        rs.getString("content")),
                selectPostsParam);
    }


    //!-- ethan
    // 게시물 생성함수
    public int insertPost(PostPostReq postPostReq){
        String insertPostQuery = "INSERT INTO Post(userIdx, imgUrl, content) VALUES (?, ?, ?)";
        Object []insertPostParams = new Object[] {postPostReq.getUserIdx(), postPostReq.getImgUrl(), postPostReq.getContent()};
        this.jdbcTemplate.update(insertPostQuery,
                insertPostParams);
        String lastInsertIdxQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInsertIdxQuery, int.class);
    }


    //db 출력 확인
    public static void main(String[] args) {
            PostDao postDao = new PostDao();
            GetPostRes post = postDao.selectPost(1);

            System.out.println(post.getPostIdx());
    }
}
