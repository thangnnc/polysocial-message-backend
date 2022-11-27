package com.polysocial.service;

import java.util.List;

import com.polysocial.dto.MessageContentDTO;
import com.polysocial.dto.MessageDTO;

public interface MessageService {

	MessageDTO createMessage(MessageDTO dto);

	List<MessageContentDTO> getMessageContent(Long roomId);

}
