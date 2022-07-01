package com.there.src.User;

import com.there.src.User.model.GetUserInfoRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 유저 피드 조회 API - 유저 정보
    public GetUserInfoRes selectUserInfo(int userIdx) {
        String selectUserInfoQuery = "select * from User where userIdx = ?";
        int selectUserInfoParam = userIdx;

        return this.jdbcTemplate.queryForObject(selectUserInfoQuery,
                (rs, rowNum) -> new GetUserInfoRes(
                        rs.getInt("userIdx"),
                        rs.getString("nickName"),
                        rs.getString("email"),
                        rs.getString("profileImgUrl"),
                        rs.getString("Info"),
                        rs.getString("birth"),
                        rs.getString("status"),
                        rs.getString("sex"),
                        rs.getString("name")),
                selectUserInfoParam);
    }

    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        GetUserInfoRes user = userDao.selectUserInfo(1);

        System.out.println(user.getUserIdx());

    }

}
