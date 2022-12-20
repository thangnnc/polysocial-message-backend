package com.polysocial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polysocial.dto.ViewedStatusDTO;
import com.polysocial.repository.ViewedStatusRepository;
import com.polysocial.service.ViewedStatusService;

@Service
public class ViewedStatusServiceImpl implements ViewedStatusService{

	@Autowired 
	ViewedStatusRepository viewedStatusRepository;
	
	@Override
	public ViewedStatusDTO updateViewedStatus(ViewedStatusDTO dto) {
		try {
			viewedStatusRepository.updateViewedStatus(dto.getContactId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}
	
	@Override
	public ViewedStatusDTO updateAllViewedStatus(ViewedStatusDTO dto) {
		try {
			viewedStatusRepository.updateAllViewed(dto.getUserId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
	}
}
