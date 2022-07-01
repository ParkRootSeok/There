package com.there.src.User;

import com.there.config.BaseException;
import com.there.config.BaseResponse;
import com.there.src.User.model.GetUserFeedRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final UserProvider userProvider;
    @Autowired
    private final UserService userService;




    public UserController(UserProvider userProvider, UserService userService){
        this.userProvider = userProvider;
        this.userService = userService;
    }

    /**
     * 유저 피드 조회 API
     * [GET] /users/:userIdx
     * @return BaseResponse<GetUserFeedRes>
     */

    @ResponseBody
    @GetMapping("/{userIdx}")
    public BaseResponse<GetUserFeedRes> getUserFeed(@PathVariable("userIdx")int userIdx) {
        try{

            GetUserFeedRes getUserFeed = userProvider.retrieveUserFeed(userIdx);

            return new BaseResponse<>(getUserFeed);

        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }
}
