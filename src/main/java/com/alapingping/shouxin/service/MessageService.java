package com.alapingping.shouxin.service;

import com.alapingping.shouxin.entity.Message;

import java.util.List;

public interface MessageService {

    List<Message> getAllMessages();
    String addMessage(Message message);

}
