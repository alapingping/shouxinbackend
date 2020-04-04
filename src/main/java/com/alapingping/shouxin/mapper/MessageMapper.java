package com.alapingping.shouxin.mapper;

import com.alapingping.shouxin.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    List<Message> getAllMessages();
    void addMessage(Message message);

}
