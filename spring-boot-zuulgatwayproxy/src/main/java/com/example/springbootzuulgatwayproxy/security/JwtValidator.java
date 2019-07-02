package com.example.springbootzuulgatwayproxy.security;

import com.example.springbootzuulgatwayproxy.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator  {


    private String secret = "youtube";

    @Autowired
    public JwtUser jwtUser;

    public JwtUser validate(String token) {

            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();

            jwtUser.setUserName(body.getSubject());

            jwtUser.setRole((String) body.get("role"));


        return jwtUser;
    }
}
