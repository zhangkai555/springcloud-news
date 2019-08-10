package com.news.user.controller.user;

import com.news.common.controller.BaseController;
import com.news.common.model.response.TokenResponse;
import com.news.common.model.response.UserInfo;
import com.news.common.result.SingleResult;
import com.news.user.model.request.LoginRequest;
import com.news.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("user")
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public SingleResult<TokenResponse> login(@Valid @RequestBody LoginRequest request, BindingResult result){
        validate(result);
        return userService.login(request);
    }

    @RequestMapping("get")
    public SingleResult<UserInfo> getUserInfo(@RequestParam("userId") Integer userId){
        SingleResult<UserInfo> userInfoSingleResult = userService.getUserInfo(userId);
        return userInfoSingleResult;
    }

}
