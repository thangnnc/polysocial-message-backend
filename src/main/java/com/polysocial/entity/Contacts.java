package com.polysocial.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Contacts implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactId;
	
	private Boolean isAdmin;
	
	private Long userId;
	
	private Long roomId;
}
