package com.atsspt.online_xiaoxiang.interceptor;



import com.atsspt.online_xiaoxiang.utils.JWTUtils;
import com.atsspt.online_xiaoxiang.utils.JsonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.springframework.lang.Nullable;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {
    //进入controller之前的方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String accesstoken = request.getHeader("token");
            if(accesstoken == null){
                accesstoken = request.getParameter("token");
            }
            if(StringUtils.isNotBlank(accesstoken)){
                Claims claims = JWTUtils.checkJWT(accesstoken);
                //登录过期
                if(claims == null){
                    sendJsonMessage(response, JsonData.buildError("登录过期"));
                    return false;
                }
                int id = (Integer) claims.get("id");
                String name = (String) claims.get("name");
                request.setAttribute("userid",id);
                request.setAttribute("name",name);
                return true;
            }
        }catch (Exception e){

        }
        sendJsonMessage(response, JsonData.buildError("登录过期"));
        return false;
    }
    //响应json数据给前端
    public  static  void sendJsonMessage(HttpServletResponse response,Object obj){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write(objectMapper.writeValueAsString(obj));
            printWriter.close();
            response.flushBuffer();
        }catch (Exception e){

        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
