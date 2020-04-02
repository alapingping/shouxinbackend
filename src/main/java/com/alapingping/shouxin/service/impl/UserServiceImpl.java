package com.alapingping.shouxin.service.impl;

import com.alapingping.shouxin.Consts;
import com.alapingping.shouxin.entity.User;
import com.alapingping.shouxin.mapper.UserMapper;
import com.alapingping.shouxin.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Override
    public User getUserByUsername(String username) {
        try(SqlSession session = Consts.getSession().openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getUserByUsername(username);
            session.close();
            return user;
        }
    }

    @Override
    public String addUser(User user) {
        String msg;
        if (this.getUserByUsername(user.getUsername()) != null) {
            msg = "插入失败，该用户已存在.";
        }
        else {
            try(SqlSession session = Consts.getSession().openSession()) {
                UserMapper mapper = session.getMapper(UserMapper.class);
                mapper.addUser(user);
                session.commit();
            }
            msg = "添加用户成功";
        }
        return msg;
    }

    @Override
    public String login(String username, String password) {
        String msg = null;
        User user = this.getUserByUsername(username);
        if (user == null) {
            msg = "登陆失败，该用户不存在";
        }
        else if(!user.getPassword().equals(password)){
            msg = "登陆失败，密码错误";
        }
        else {
            msg = "登陆成功";
        }
        return msg;
    }

    @Override
    public String register(User user) {
        return this.addUser(user);
    }
}
