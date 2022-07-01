package com.there.src.User;

import com.there.src.User.model.GetUserInfoRes;
import com.there.src.User.model.GetUserPostsRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // !-- ethan
    // 유저 피드 조회 API - 유저 정보
    public GetUserInfoRes selectUserInfo(int userIdx) {
        String selectUserInfoQuery = "select * from User where userIdx = ?";
        int selectUserInfoParam = userIdx;

        return this.jdbcTemplate.queryForObject(selectUserInfoQuery,
                (rs, rowNum) -> new GetUserInfoRes(
                        rs.getInt("userIdx"),
                        rs.getString("name"),
                        rs.getString("nickName"),
                        rs.getString("profileImgUrl"),
                        rs.getString("Info")
                        ), selectUserInfoParam);
    }

    // !-- ethan
    // 유저 피드 조회 API - 게시물 리스트
    public List<GetUserPostsRes> selectUserPosts(int userIdx){

        String selectUserPostsQuery ="select p.postIdx as postIdx,\n" +
                "       p.imgUrl as imgUrl,\n" +
                "       p.content as content\n" +
                "from Post as p\n" +
                "    join User as u on u.userIdx = p.userIdx\n" +
                "where p.status ='ACTIVE' and u.userIdx=?\n" +
                "order by p.created_At desc;";
        int selectUserPostsParam = userIdx;

        return this.jdbcTemplate.query(selectUserPostsQuery,
                (rs, rowNum) -> new GetUserPostsRes(
                        rs.getInt("postIdx"),
                        rs.getString("imgUrl"),
                        rs.getString("content")
                ), selectUserPostsParam);


    }


    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        GetUserInfoRes user = userDao.selectUserInfo(1);

        System.out.println(user.getUserIdx());

    }

}
