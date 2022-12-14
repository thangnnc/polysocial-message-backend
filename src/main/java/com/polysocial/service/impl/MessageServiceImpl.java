package com.polysocial.service.impl;

import com.polysocial.dto.GroupNameDTO;
import com.polysocial.dto.MessageContentDTO;
import com.polysocial.dto.MessageDTO;
import com.polysocial.dto.RoomRequestDTO;
import com.polysocial.entity.Contacts;
import com.polysocial.entity.Messages;
import com.polysocial.entity.RoomChats;
import com.polysocial.entity.ViewedStatus;
import com.polysocial.repository.ContactsResponsetory;
import com.polysocial.repository.MessageResponsetory;
import com.polysocial.repository.RoomChatRepository;
import com.polysocial.repository.ViewedStatusRepository;
import com.polysocial.service.MessageService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

	@Autowired
	private RoomChatRepository roomChatRepository;

	@Autowired
	private ContactsResponsetory contactsResponsetory;

	@Autowired
	ViewedStatusRepository viewedStatusRepository;

	public MessageDTO createMessage(MessageDTO dto) {
		try {
			//encodedString
			String encodedString = Base64.getEncoder().encodeToString(dto.getContent().getBytes());
			dto.setContent(encodedString);
			
			Messages message = new Messages();
			message.setContent(dto.getContent());
			message.setContactId(dto.getContactId());
			message.setCreatedDate(LocalDateTime.now());
			message.setStatus(true);
			message.setStatusCreated(true);
			message.setMessageRecall(true);
			messageResponsetory.save(message);

			Optional<RoomChats> list = roomChatRepository.findById(dto.getRoomId());
			RoomChats room = list.get();
			room.setLastUpDateDate(LocalDateTime.now());
			room.setLastMessage(dto.getContent());
			roomChatRepository.save(room);

			ViewedStatus viewedStatus = new ViewedStatus();
			for (int i = 0; i < dto.getListcontactId().length; i++) {
				try {
					Long contactId = dto.getListcontactId()[i];
					ViewedStatus viewStatusONE = viewedStatusRepository.updateViewedFALSE(contactId);
					viewStatusONE.setLastUpDateDate(LocalDateTime.now());
					viewStatusONE.setStatus(false);
					viewedStatusRepository.save(viewStatusONE);
				} catch (Exception e) {

				}
				//
				viewedStatus.setContactId(dto.getListcontactId()[i]);
				viewedStatus.setLastUpDateDate(LocalDateTime.now());
				viewedStatus.setStatus(false);
				viewedStatusRepository.save(viewedStatus);
			}
			ViewedStatus viewOne = new ViewedStatus();
			viewOne.setContactId(dto.getContactId());
			viewOne.setLastUpDateDate(LocalDateTime.now());
			viewOne.setStatus(true);

			viewedStatusRepository.save(viewOne);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	@Override
	public List<MessageContentDTO> getMessageContent(RoomRequestDTO request) {
		try {
			List<MessageContentDTO> dto = new ArrayList<>();
			List<Object[]> list = messageResponsetory.findMessageAll(request.getPage(), request.getLimit(),
					request.getRoomId());
			for (Object[] objects : list) {
				MessageContentDTO listMessage = new MessageContentDTO();
				listMessage.setIsAdmin(Boolean.parseBoolean(objects[0].toString()));
				listMessage.setStudentCode(objects[1].toString());
				listMessage.setFullName(objects[2].toString());
				listMessage.setAvatar(objects[3].toString());
				
				//decodedString
				byte[] decodedBytes = Base64.getDecoder().decode(objects[4].toString());
				String decodedString = new String(decodedBytes);
				
				listMessage.setContent(decodedString);
				listMessage.setCreatedDate(objects[5].toString());
				listMessage.setStatusCreated(Boolean.parseBoolean(objects[6].toString()));
				listMessage.setEmail(objects[7].toString());
				listMessage.setMessageRecall(Boolean.parseBoolean(objects[8].toString()));
				dto.add(listMessage);
			}
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<GroupNameDTO> getNameGroupDESC(GroupNameDTO request) {
		try {
			List<GroupNameDTO> dto = new ArrayList<>();
			List<Object[]> list = messageResponsetory.getNameGroupDESC(request.getUserId());
			for (Object[] objects : list) {
				GroupNameDTO listGroup = new GroupNameDTO();
				Long roomId = Long.parseLong(objects[0].toString());
				listGroup.setRoomId(roomId);
				List<Object[]> listContact = contactsResponsetory.getContactByRoomId(roomId);
				List<Object[]> listObject = new ArrayList<>();

				for (Object[] contact : listContact) {
					listObject.add(contact);
				}
				List<Object[]> arr = new ArrayList<>();
				for (Object[] obj : listObject) {
					arr.add(obj);

				}
				listGroup.setListContacts(arr);

				try {
					listGroup.setName(objects[1].toString());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					listGroup.setAvatar(objects[2].toString());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					//decodedString
					byte[] decodedBytes = Base64.getDecoder().decode(objects[3].toString());
					String decodedString = new String(decodedBytes);
					listGroup.setLastMessage(decodedString);
				} catch (Exception e) {
					// TODO: handle exception
				}
				listGroup.setTotalMember(Long.parseLong(objects[4].toString()));
				try {
					listGroup.setLastUpDateDate(objects[5].toString());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					listGroup.setStatus(Boolean.parseBoolean(objects[6].toString()));
				} catch (Exception e) {
					// TODO: handle exception
				}
				dto.add(listGroup);
			}

			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
