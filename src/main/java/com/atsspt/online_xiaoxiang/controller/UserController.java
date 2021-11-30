package com.atsspt.online_xiaoxiang.controller;

import com.atsspt.online_xiaoxiang.model.entity.User;
import com.atsspt.online_xiaoxiang.model.request.LoginRequest;
import com.atsspt.online_xiaoxiang.service.UserService;
import com.atsspt.online_xiaoxiang.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public JsonData register(@RequestBody  Map<String,String> userInfo){
        int rows = userService.Save(userInfo);

        return rows== 0  ? JsonData.buildSuccess() : JsonData.buildError("注册失败，重试");

    }
    @PostMapping("logging")
    public JsonData login(@RequestBody LoginRequest loginRequest){
        String token = userService.findTokenByPhonePwd(loginRequest.getPhone(),loginRequest.getPwd());
        return token==null?JsonData.buildError("登录失败，账号密码错误") : JsonData.buildSuccess(token);
    }
    /*
    * 根据用户id查询用户信息
    * */
    @RequestMapping("finduserbytoken")
    public JsonData findUserByToken(HttpServletRequest servletRequest){
        Integer userId = (Integer)servletRequest.getAttribute("userid");

        if(userId == null){
            return JsonData.buildError("查询失败");
        }
        User user = userService.findByUserId(userId);
        return  JsonData.buildSuccess(user);
    }
    
    
}
