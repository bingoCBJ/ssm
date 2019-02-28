package com.ssm.notebook.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssm.notebook.mapper.UserDao;
import com.ssm.notebook.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    Logger logger = LoggerFactory.getLogger(getClass());

    public static final String RETURN_TYPE = "json";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserDao userDao;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws  IOException {
        logger.info("登陆成功");
        logger.info("username=>" + request.getParameter("userid"));
        if (RETURN_TYPE.equals("html")){
            redirectStrategy.sendRedirect(request, response, "/html/index");
        }else {
            User user = userDao.loadUserByUsername( request.getParameter("userid") );
            Map<String, Object> map = new HashMap<>();
            map.put("code","0");
            map.put("result","登录成功");
            map.put("data",authentication);
            map.put("user_id",user.getId());
            map.put("user_name",user.getName());
            map.put("user_role",user.getRole());
            //Cookie userCookie = new Cookie("username",request.getParameter("userid"));
            //userCookie.setPath("/");
            //response.addCookie(userCookie);
            //response.setContentType("text/html;charset=UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(map));

        }

    }
}
