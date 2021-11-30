package com.atsspt.online_xiaoxiang.service;

import com.atsspt.online_xiaoxiang.model.entity.User;

import java.util.Map;

public interface UserService {
    int Save(Map<String,String> userinfo);
    User findByPhone(String phone);

    String findTokenByPhonePwd(String phone, String pwd);

    User findByUserId(Integer userid);
}
