package com.polysocial.rest.controller;

import com.polysocial.consts.MessAPI;
import com.polysocial.dto.MessageDTO;
import com.polysocial.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping(MessAPI.API_GET_MESSAGE)
    public MessageDTO getMessage(){
        MessageDTO response = messageService.getMessage();
        return response;
    }
}
