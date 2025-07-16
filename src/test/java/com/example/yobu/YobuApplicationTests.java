package com.example.yobu;

import com.example.yobu.security.JwtUtil;
import com.example.yobu.tool.LocationTool;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

//@SpringBootTest
class YobuApplicationTests {

    private JwtUtil jwtUtil;

    @Test
    void contextLoads() {
        JwtUtil jwtUtil = new JwtUtil();
        String token = jwtUtil.generateTokenWithClaims("testUser", 12345);
        System.out.println("Generated Token: " + token);

        String userName = jwtUtil.getUserNameFromToken(token);
        System.out.println("UserId from Token: " + userName);

        boolean isValid = jwtUtil.validateToken(token);
        System.out.println("Is Token Valid: " + isValid);
    }
}
