package com.alapingping.shouxin.mapper;

import com.alapingping.shouxin.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserByID(int id);
    User getUserByUsername(String username);
    int addUser(User user);
}
