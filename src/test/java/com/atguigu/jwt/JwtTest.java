package com.atguigu.jwt;

import com.atguigu.jwt.entity.Member;
import com.atguigu.jwt.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.Test;



public class JwtTest {

    @Test
    public void testGenerateJWT(){
        Member member = new Member();
        member.setId("10000");
        member.setNickname("Helen");
        member.setAvatar("1.png");
        String jwt = JwtUtils.generateJWT(member.getId(), member.getNickname(), member.getAvatar());
        System.out.println(jwt);
    }

    @Test
    public void testCheckJWT(){

        Claims claims = JwtUtils.checkJWT("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJndWxpLXVzZXIiLCJpYXQiOjE1ODM0Nzc3MTUsImV4cCI6MTU4MzQ3OTUxNSwiaWQiOiIxMDAwMCIsIm5pY2tuYW1lIjoiSGVsZW4iLCJhdmF0YXIiOiIxLnBuZyJ9.2EZBvRfGhg1sFBoO_Ra7QSs4YX_VhHKMyKCRR8eLqWk");

        String id = (String)claims.get("id");
        String nickname = (String)claims.get("nickname");
        String avatar = (String)claims.get("avatar");

        System.out.println(id);
        System.out.println(nickname);
        System.out.println(avatar);
    }
}