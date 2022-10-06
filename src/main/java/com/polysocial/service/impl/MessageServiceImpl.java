package com.polysocial.service.impl;

import com.polysocial.dto.MessageDTO;
import com.polysocial.entity.Message;
import com.polysocial.service.MessageService;
import com.polysocial.utils.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MessageDTO getMessage() {
        Logger.info("Start getMessage service");
        try {
            Message message = new Message("Cao Thăng", "Mậu Phi", "Hoàng Duy", "Đăng Trường");
            MessageDTO response = modelMapper.map(message, MessageDTO.class);
            return response;
        }catch (Exception ex){
            Logger.error("Get message exception: " + ex);
            return null;
        }
    }
}
