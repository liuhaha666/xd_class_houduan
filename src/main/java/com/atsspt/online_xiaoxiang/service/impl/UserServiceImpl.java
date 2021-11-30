package com.atsspt.online_xiaoxiang.service.impl;

import com.atsspt.online_xiaoxiang.model.entity.User;
import com.atsspt.online_xiaoxiang.mapper.UserMapper;
import com.atsspt.online_xiaoxiang.service.UserService;
import com.atsspt.online_xiaoxiang.utils.CommonUtils;
import com.atsspt.online_xiaoxiang.utils.JWTUtils;
import com.atsspt.online_xiaoxiang.utils.JsonData;
import io.jsonwebtoken.Jwts;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int Save(Map<String,String> userinfo) {
        User user = praseToUser(userinfo);
        System.out.println(userinfo);
        if(user != null){
            userMapper.Save(user);
        }else{
            return -1;
        }
        return 0;
    }

    public User findByPhone(@Param("phone") String phone) {
        return null;
    }

    @Override
    public String findTokenByPhonePwd(String phone, String pwd) {
        User user = userMapper.findTokenByPhonePwd(phone, CommonUtils.MD5(pwd));
        if(user == null){
            return null;
        }else{
            String token = JWTUtils.genJsonWebToken(user);
            return token;
        }
    }

    @Override
    public User findByUserId(Integer userid) {
        User user = userMapper.findByUserId(userid);
        return user;
    }

    /*
     *解析函数
     *  */
    private User praseToUser(Map<String,String> userinfo){
        if(userinfo.containsKey("phone")&& userinfo.containsKey("pwd")&& userinfo.containsKey("name")){
            User user = new User();
            user.setName(userinfo.get("name"));
            user.setPhone(userinfo.get("phone"));
            user.setCreateTime(new Date());
            user.setHeadImg("");
            String pwd = userinfo.get("pwd");
            //加密
            user.setPwd(CommonUtils.MD5(pwd));
            return user;
        }else{
            return null;
        }
    }


}
