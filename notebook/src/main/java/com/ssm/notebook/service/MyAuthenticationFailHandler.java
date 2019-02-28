package com.ssm.notebook.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

@Component
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {
    Logger logger = LoggerFactory.getLogger(getClass());

    public static final String RETURN_TYPE = "json"; // 登录失败时，用来判断是返回json数据还是跳转html页面

    @Autowired
    private ObjectMapper objectMapper;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("登录失败:" + exception.getMessage());
        logger.info("username=>" + request.getParameter("userid"));

        if (RETURN_TYPE.equals("html")) {
            redirectStrategy.sendRedirect(request, response, "/html/login");
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("code","1002");
            map.put("result","登录失败");
            map.put("data",exception.getMessage());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(map));
        }
    }
}
