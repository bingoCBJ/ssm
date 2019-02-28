package com.ssm.notebook.mapper;

import com.ssm.notebook.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    User loadUserByUsername(String name);

}
