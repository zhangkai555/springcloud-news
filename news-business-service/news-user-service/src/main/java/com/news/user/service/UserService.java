package com.news.user.service;

import com.news.common.model.response.TokenResponse;
import com.news.common.model.response.UserInfo;
import com.news.common.result.Code;
import com.news.common.result.SingleResult;
import com.news.common.service.BaseService;
import com.news.user.mapper.UserMapper;
import com.news.user.model.bean.UserBean;
import com.news.user.model.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
public class UserService extends BaseService {

    @Autowired
    private UserMapper userMapper;

    public SingleResult<TokenResponse> login(LoginRequest request){
        List<UserBean> userList = userMapper.selectUser(request.getMobile(),request.getPassword());
        if(null != userList && userList.size() > 0){
            String token = getToken(request.getMobile(),request.getPassword());
            TokenResponse response = new TokenResponse();
            response.setToken(token);
            return SingleResult.buildSuccess(response);
        }else {
            return SingleResult.buildFailure(Code.ERROR,"手机号或密码输入不正确！");
        }
    }

    public SingleResult<UserInfo> getUserInfo(Integer userId){
        UserInfo userInfo = userMapper.getUserInfo(userId);
        return SingleResult.buildSuccess(userInfo);
    }
}
