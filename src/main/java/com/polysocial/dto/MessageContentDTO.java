package com.polysocial.dto;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

@Data
public class MessageContentDTO {

	private Boolean isAdmin;
	
	private String studentCode;
	
	private String fullName;
	
	private String avatar;
	
	private String content;

	private String createdDate;
	
	private Boolean statusCreated;
	
	private String email;
	
	private Boolean messageRecall;
	
}
