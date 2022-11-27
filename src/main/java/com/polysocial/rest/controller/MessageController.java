package com.polysocial.rest.controller;

import com.polysocial.consts.MessageAPI;
import com.polysocial.dto.MessageContentDTO;
import com.polysocial.dto.MessageDTO;
import com.polysocial.dto.ResponseDTO;
import com.polysocial.dto.RoomRequestDTO;
import com.polysocial.service.MessageService;
import com.polysocial.utils.ValidateUtils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@PostMapping(MessageAPI.API_CREATE_MESSAGE)
	public ResponseEntity createMessage(@RequestBody MessageDTO request) {
		if (ValidateUtils.isNullOrEmpty(request.getContent())) {
			ResponseDTO response = new ResponseDTO();
			response.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		} else {
			MessageDTO response = messageService.createMessage(request);
			return ResponseEntity.ok(response);
		}
	}
	
	@PostMapping(MessageAPI.API_GET_MESSAGE)
	public ResponseEntity getAllMessage(@RequestBody RoomRequestDTO request) {
		if (ValidateUtils.isNullOrEmpty(request.getRoomId())) {
			ResponseDTO response = new ResponseDTO();
			response.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		} else {
			List<MessageContentDTO> response = messageService.getMessageContent(request.getRoomId());
			return ResponseEntity.ok(response);
		}
	}
}
