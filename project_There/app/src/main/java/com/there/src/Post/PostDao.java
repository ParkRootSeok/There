package com.there.src.Post;

import com.there.src.Post.model.GetHistoryRes;
import com.there.src.Post.model.GetPostRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class PostDao {

    private JdbcTemplate jdbcTemplate;
    private int historyIdx;


    @Autowired
    public void setDataSource(DataSource dataSource){

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    // 게시글 조회
    public GetPostRes selectPostInfo(int postIdx){
        String selectInfoPostQuery = "select * from Post where postIdx = ?";
        int selectPostsParam = postIdx;

        return this.jdbcTemplate.queryForObject(selectInfoPostQuery,
                (rs, rowNum) -> new GetPostRes(
                        rs.getInt("postIdx"),
                        rs.getString("imgUrl"),
                        rs.getString("content"),
                        rs.getString("created_At"),
                        rs.getString("status"),
                        rs.getInt("userIdx")),
                selectPostsParam);
    }

    // 히스토리 게시글 조회
    public GetHistoryRes selectHisPostInfo(int historyIdx) {
        this.historyIdx = historyIdx;
        String selectHisPostInfoQuery = "select * from History where historyIdx = ?";
        int selectHisPostsParam = historyIdx;

        return this.jdbcTemplate.queryForObject(selectHisPostInfoQuery,
                (rs, rowNum) -> new GetHistoryRes(
                        rs.getInt("historyIdx"),
                        rs.getInt("postIdx"),
                        rs.getString("title"),
                        rs.getString("imgUrl"),
                        rs.getString("content"),
                        rs.getString("created_At"),
                        rs.getString("status")),
                selectHisPostsParam);
    }

    // 게시물 유저 확인
    /*public int checkUserPostExist(int userIdx, int postIdx){
        String checkUserPostQuery= "select exists(select postIdx from Post where postIdx =? and userIdx=?)";
        Object[] checkUserPostParams = new Object[]{postIdx, userIdx};
        return this.jdbcTemplate.queryForObject(checkUserPostQuery,
                int.class,
                checkUserPostParams);
    }
*/
    //db 출력 확인
    public static void main(String[] args) {
            PostDao postDao = new PostDao();
            GetPostRes post = postDao.selectPostInfo(1);

            System.out.println(post.getPostIdx());

    }

}
