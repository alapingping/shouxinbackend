package com.alapingping.shouxin.controller;

import com.alapingping.shouxin.entity.User;
import com.alapingping.shouxin.service.UserService;
import com.alapingping.shouxin.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;
    private String msg;
    private int code;

    @GetMapping(value = "/get")
    public JsonResult<User> getUserByUsername(@RequestParam("username") String username) {
        User user = service.getUserByUsername(username);
        code = 200;
        if (user != null) msg = "查询成功";
        else msg = "查询失败，该用户不存在";
        return new JsonResult<>(user, code, msg);
    }

    @GetMapping(value = "/login")
    public JsonResult<User> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        code = 200;
        msg = service.login(username, password);
        return new JsonResult<>(code, msg);
    }

    @PostMapping(value = "/register")
    public JsonResult<User> register(@RequestBody User user) {
        code = 200;
        msg = service.addUser(user);
        return new JsonResult<>(code, msg);
    }

}
