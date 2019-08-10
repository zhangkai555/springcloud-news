package com.news.order.controller;

import com.news.common.controller.BaseController;
import com.news.common.model.request.LoginRequest;
import com.news.common.model.response.TokenResponse;
import com.news.common.result.SingleResult;
import com.news.order.feign.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author zhangkai
 * @date 2019年08月10日 18:51
 */
@RequestMapping("order")
@RestController
public class OrderController extends BaseController{

    @Autowired
    private UserServiceFeign userServiceFeign;

    @RequestMapping("userLogin")
    public SingleResult<TokenResponse> getUserInfo(){
        LoginRequest request = new LoginRequest();
        request.setPassword("123456");
        request.setMobile("13455798355");
        SingleResult<TokenResponse> userInfoResult =  userServiceFeign.userLogin(request);
        return userInfoResult;
    }


}
