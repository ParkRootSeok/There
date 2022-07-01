package com.there.src.User;

import com.there.config.BaseException;
import com.there.src.User.model.GetUserFeedRes;
import com.there.src.User.model.GetUserInfoRes;
import com.there.src.User.model.GetUserPostsRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.there.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class UserProvider {

    private final UserDao userDao;


    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserProvider(UserDao userDao) {
        this.userDao = userDao;

    }

    public GetUserFeedRes retrieveUserFeed(int userIdx) throws BaseException {


        try {

            GetUserInfoRes getUserInfo = userDao.selectUserInfo(userIdx);
            List<GetUserPostsRes> getUserPosts = userDao.selectUserPosts(userIdx);

            GetUserFeedRes getUserFeed = new GetUserFeedRes(getUserInfo, getUserPosts);
            return getUserFeed;
        } catch (Exception exception) {
            System.out.println(exception);
            throw new BaseException(DATABASE_ERROR);
        }


    }
}
