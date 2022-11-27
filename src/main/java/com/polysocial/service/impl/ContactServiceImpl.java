package com.polysocial.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polysocial.dto.ContactDTO;
import com.polysocial.entity.Contacts;
import com.polysocial.repository.ContactRepository;
import com.polysocial.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	ContactRepository contactRepository;
	
	@Override
	public ContactDTO createContact(ContactDTO dto) {
		try {
			Contacts contact = modelMapper.map(dto, Contacts.class);
			contactRepository.save(contact);
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
