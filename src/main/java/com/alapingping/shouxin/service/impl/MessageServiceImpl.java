package com.alapingping.shouxin.service.impl;

import com.alapingping.shouxin.Consts;
import com.alapingping.shouxin.entity.Message;
import com.alapingping.shouxin.mapper.MessageMapper;
import com.alapingping.shouxin.service.MessageService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MessageService")
public class MessageServiceImpl implements MessageService {

    @Override
    public List<Message> getAllMessages() {
        try(SqlSession session = Consts.getSession().openSession()) {
            MessageMapper mapper = session.getMapper(MessageMapper.class);
            List<Message> messages = mapper.getAllMessages();
            session.close();
            return messages;
        }
    }

    @Override
    public String addMessage(Message message) {
        try(SqlSession session = Consts.getSession().openSession()) {
            MessageMapper mapper = session.getMapper(MessageMapper.class);
            mapper.addMessage(message);
            session.commit();
            session.close();
            return "发布成功";
        }
    }
}
