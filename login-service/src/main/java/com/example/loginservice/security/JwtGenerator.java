package com.example.loginservice.security;



import com.example.loginservice.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {


    public String generate(UserEntity userEntity) {


        Claims claims = Jwts.claims()
                .setSubject(userEntity.getUserName());
        claims.put("userId", String.valueOf(userEntity.getId()));
        claims.put("role", userEntity.getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")

                .compact();
    }
}
