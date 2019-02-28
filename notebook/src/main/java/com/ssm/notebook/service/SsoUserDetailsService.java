package com.ssm.notebook.service;

import com.ssm.notebook.mapper.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class SsoUserDetailsService implements UserDetailsService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.ssm.notebook.model.User user = userDao.loadUserByUsername(username);
        if (user == null) {
            logger.info("User对象为空");
            //避免返回null，这里返回一个不含有任何值的User对象，在后期的密码比对过程中一样会验证失败
            throw new UsernameNotFoundException(username);
        }
        return new User(username, passwordEncoder.encode(user.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_"+user.getRole()));
    }

}
