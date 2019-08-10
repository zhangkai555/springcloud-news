package com.news.user.mapper;

import com.news.common.model.response.UserInfo;
import com.news.user.model.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select id,mobile,password from news_user where mobile = #{mobile} and password = #{password}")
    List<UserBean> selectUser(@Param("mobile") String mobile, @Param("password") String password);

    @Select("select id,mobile,password from news_user where mobile = #{mobile}")
    List<UserBean> selectUserByMobile(String mobile);

    @Select("select id,mobile,password from news_user where id = #{id}")
    UserInfo getUserInfo(@Param("id") Integer id);
}
