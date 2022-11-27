package com.polysocial.service.impl;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polysocial.dto.RoomChatDTO;
import com.polysocial.entity.RoomChats;
import com.polysocial.repository.RoomChatRepository;
import com.polysocial.service.RoomChatServer;

@Service
public class RoomChatServiceImpl implements RoomChatServer {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RoomChatRepository roomChatRepository;

	@Override
	public RoomChatDTO createRoomChat(RoomChatDTO dto) {
		try {
			RoomChats room = modelMapper.map(dto, RoomChats.class);
			room.setCreatedDate(LocalDate.now());
			room.setStatus(true);
			roomChatRepository.save(room);
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
