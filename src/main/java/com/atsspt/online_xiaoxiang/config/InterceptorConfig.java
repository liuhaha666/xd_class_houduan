package com.atsspt.online_xiaoxiang.config;

import com.atsspt.online_xiaoxiang.interceptor.CorsInterceptor;
import com.atsspt.online_xiaoxiang.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    LoginInterceptor loginInterceptor(){
        return  new LoginInterceptor();
    }
    @Bean
    CorsInterceptor corsInterceptor(){
        return new CorsInterceptor();
    };
    //配置拦截规则
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry ){
        //跨域配置
        interceptorRegistry.addInterceptor(corsInterceptor()).addPathPatterns("/**");
        interceptorRegistry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")
        .excludePathPatterns("/api/v1/pri/user/register","/api/v1/pri/user/logging");
        WebMvcConfigurer.super.addInterceptors(interceptorRegistry);
    }
}
