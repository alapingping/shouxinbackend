package com.alapingping.shouxin.controller;

import com.alapingping.shouxin.entity.Message;
import com.alapingping.shouxin.service.MessageService;
import com.alapingping.shouxin.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    private MessageService service;
    private String msg;
    private int code;

    @GetMapping(value = "/getAll")
    public JsonResult<Message> getAllMessages() {
        List<Message> messages = service.getAllMessages();
        code = 200;
        if (messages != null) msg = "查询成功";
        else msg = "查询失败";
        return new JsonResult<>(messages, code, msg);
    }

    @PostMapping(value = "/publishMessage")
    public JsonResult<Message> addMessage(@RequestBody Message message) throws ParseException {
        code = 200;
        msg = service.addMessage(message);
        return new JsonResult<>(code, msg);
    }

}
