package com.polysocial.service.impl;

import com.polysocial.dto.MessageContentDTO;
import com.polysocial.dto.MessageDTO;
import com.polysocial.entity.Messages;
import com.polysocial.repository.MessageResponsetory;
import com.polysocial.service.MessageService;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private MessageResponsetory messageResponsetory;

	public MessageDTO createMessage(MessageDTO dto) {
		try {
				Messages message = new Messages();
				message.setContent(dto.getContent());
				message.setContactId(dto.getContactId());
				message.setCreatedDate(LocalDateTime.now());
				message.setStatus(true);
				messageResponsetory.save(message);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<MessageContentDTO> getMessageContent(Long roomId) {
		try {
			List<MessageContentDTO> dto = new ArrayList<>();

			List<Object[]> list = messageResponsetory.findMessageAll(roomId);
			for (Object[] objects : list) {
				MessageContentDTO listMessage = new MessageContentDTO();
				listMessage.setIsAdmin(Boolean.parseBoolean(objects[0].toString()));
				listMessage.setStudentCode(objects[1].toString());
				listMessage.setFullName(objects[2].toString());
				listMessage.setAvatar(objects[3].toString());
				listMessage.setContent(objects[4].toString());
				listMessage.setCreatedDate(objects[5].toString());
				dto.add(listMessage);
			}
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
