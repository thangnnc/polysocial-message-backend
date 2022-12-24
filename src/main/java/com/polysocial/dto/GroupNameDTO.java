package com.polysocial.dto;

import java.util.List;

import com.polysocial.entity.Contacts;

import lombok.Data;

@Data
public class GroupNameDTO {
	
	private Long roomId;
	
	private String name;
	
	private String avatar;
	
	private String lastMessage;	
	
	private Long userId;
	
	private Long totalMember;
	
	private String lastUpDateDate;
	
	private Boolean status;
	
	private Long contactId;
	
	private List<Object[]> listContacts;

	
}
