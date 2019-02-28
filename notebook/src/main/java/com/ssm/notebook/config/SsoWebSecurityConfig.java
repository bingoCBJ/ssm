package com.ssm.notebook.config;

import com.ssm.notebook.service.MyAuthenticationFailHandler;
import com.ssm.notebook.service.MyAuthenticationSuccessHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

    /**
     * spring Security配置
     *
     */

@Configuration
public class SsoWebSecurityConfig extends WebSecurityConfigurerAdapter {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MyAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailHandler authenticationFailHandler;

    @Override
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/html/login")
                .loginProcessingUrl("/user/login")
                .usernameParameter("userid")
                .passwordParameter("token")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailHandler)
            .and().authorizeRequests()
                .antMatchers("/html/login", "/static/**/*.*")
                .permitAll()
                //.antMatchers("/user/**").hasAnyRole("USER") // 需要具有ROLE_USER角色才能访问
                //.antMatchers("/admin/**").hasAnyRole("ADMIN") // 需要具有ROLE_ADMIN角色才能访问
                .anyRequest().authenticated()
            .and()
                .logout()
                .logoutUrl("/user/logout")
            .and()
                .sessionManagement().invalidSessionUrl("/html/login")//配置登陆过期之后访问的接口
            .and()
                .csrf().disable();
        logger.info("configure(HttpSecurity http)执行完成");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        logger.info("configure(AuthenticationManagerBuilder auth)执行完成");
    }
}

