package com.there.src.User;

import com.there.src.User.model.GetUserInfoRes;
import com.there.src.User.model.User;
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
        String selectUserInfoQuery = "select * from User where userId = ?";
        int selectUserInfoParam = userIdx;

        return this.jdbcTemplate.queryForObject(selectUserInfoQuery, (rs, rowNum) -> new User(
                        rs.getInt("userid"),
                        rs.getString("nickName"),
                        rs.getString("email"),
                        rs.getString("name"),
                        rs.getString("sex"),
                        rs.getString("birth"),
                        rs.getString("status")),
                selectUserInfoParam);
    }

    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        User user = userDao.selectUserInfo(1);

        System.out.println(user.getUserid());

    }

}
