package com.polysocial.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RoomChatDTO {

//	private Long roomId;

	private Long groupId;

	private Boolean status;

	private LocalDate LastUpDateDate;

	private String lastMessage;
}
