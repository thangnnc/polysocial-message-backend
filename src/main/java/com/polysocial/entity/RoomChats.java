package com.polysocial.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class RoomChats implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roomId;
	
	private Long groupId;

	private Boolean status;

	private LocalDate createdDate;
}
