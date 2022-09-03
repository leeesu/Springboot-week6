package com.example.springbootweek6.jwt;

import com.example.springbootweek6.Dto.Response.ResponseErrorDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointException implements
        AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(
                new ObjectMapper().writeValueAsString(
                       ResponseErrorDto.builder()
                                .code("MEMBER_NOT_FOUND")
                                .message("로그인이 필요합니다")
                                .build()
                )
        );
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
}
