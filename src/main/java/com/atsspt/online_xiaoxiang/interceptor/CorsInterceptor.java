package com.atsspt.online_xiaoxiang.interceptor;

import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //指定允许其他域名访问
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));
        ////是否允许后续请求携带认证信息（cookies）,该值只能是true,否则不返回
        response.setHeader("Access-Control-Allow-Credentials ","true");
        //允许的请求类型
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,POST");
        //允许的请求头字段
        response.setHeader("Access-Control-Allow-Headers","*");
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            return true;
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
