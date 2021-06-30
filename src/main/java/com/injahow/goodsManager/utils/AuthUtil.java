package com.injahow.goodsManager.utils;


import com.injahow.goodsManager.bean.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AuthUtil {

    public final static String SECRET = "injahow-secret-1346abc";

    public static String getToken(User user) {
        String token = "";
        JwtBuilder builder = Jwts.builder();
        Map map = new HashMap();

        map.put("name", user.getUserName());
        map.put("introduction", user.getIntroduction());
        map.put("avatar", user.getUserAvatar());

        token = builder.setSubject(user.getUserName())
                .setIssuedAt(new Date())
                .setId(user.getUserId()+"")
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
        System.out.println(token);
        return token;

    }
}
