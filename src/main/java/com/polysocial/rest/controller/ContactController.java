package com.polysocial.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.polysocial.consts.ContactAPI;
import com.polysocial.dto.ContactDTO;
import com.polysocial.dto.ResponseDTO;
import com.polysocial.service.ContactService;
import com.polysocial.utils.ValidateUtils;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping(ContactAPI.API_CREATE_CONTACT)
	public ResponseEntity createContact(@RequestBody ContactDTO dto) {
		System.out.println("-->"+dto);
		if (ValidateUtils.isNullOrEmpty(dto.getUserId())) {
			ResponseDTO response = new ResponseDTO();
			response.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		} else {
			ContactDTO response = contactService.createContact(dto);
			return ResponseEntity.ok(response);
		}
	}
}
