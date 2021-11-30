package com.atsspt.online_xiaoxiang.mapper;

import com.atsspt.online_xiaoxiang.model.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int Save(User user);
    User findByPhone(@Param("phone") String phone);

    User findTokenByPhonePwd(@Param("phone_id") String phone,@Param("pwd") String pwd);

    User findByUserId(@Param("user_id") Integer userid);
}
