package com.polysocial.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.polysocial.consts.RoomChatAPI;
import com.polysocial.dto.ResponseDTO;
import com.polysocial.dto.RoomChatDTO;
import com.polysocial.service.RoomChatServer;
import com.polysocial.utils.ValidateUtils;

@RestController
public class RoomChatController {

	@Autowired
	private RoomChatServer roomChatServer;

	@PostMapping(RoomChatAPI.API_CREATE_CHATROOM)
	public ResponseEntity create(@RequestBody RoomChatDTO request) {
		if (ValidateUtils.isNullOrEmpty(request.getGroupId())) {
			ResponseDTO response = new ResponseDTO();
			response.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		} else {
			RoomChatDTO response = roomChatServer.createRoomChat(request);
			return ResponseEntity.ok(response);
		}
	}
}
