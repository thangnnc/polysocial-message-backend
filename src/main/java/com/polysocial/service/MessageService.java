package com.polysocial.service;

import java.util.List;

import com.polysocial.dto.GroupNameDTO;
import com.polysocial.dto.MessageContentDTO;
import com.polysocial.dto.MessageDTO;
import com.polysocial.dto.RoomRequestDTO;

public interface MessageService {

	MessageDTO createMessage(MessageDTO dto);

	List<GroupNameDTO> getNameGroupDESC(GroupNameDTO request);

	List<MessageContentDTO> getMessageContent(RoomRequestDTO request);


}
