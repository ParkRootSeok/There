package com.there.User;

import com.there.User.model.User;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User selectUserInfo(int userid) {
        String selectUserInfoQuery = "select * from user where userid = ?";
        int selectUserInfoParam = userid;

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
