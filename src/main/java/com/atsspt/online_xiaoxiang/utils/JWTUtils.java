package com.atsspt.online_xiaoxiang.utils;

import com.atsspt.online_xiaoxiang.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtils {
    // 过期时间
    private static final long EXPIRE=60000 * 60 * 24 * 7;
    //加密密钥
    private static final String SECRET="fourteen";
    //令牌前缀
    private static final String TOKEN_PREFIX="xiaoxiang";
    //subject
    private static final String SUBJECT="xiaoxiang";
    //根据用户信息，生成令牌
    public static String genJsonWebToken(User user){
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id",user.getId())
                .claim("name",user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();
        token = TOKEN_PREFIX + token;
        return token;
    }

    //校验token的方法
    public static Claims  checkJWT(String token){
        try{
            final Claims cliams = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();
            return cliams;
        }catch (Exception e){
            return null;
        }
    }


}
