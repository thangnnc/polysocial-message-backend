package com.polysocial.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.polysocial.consts.ViewedStatusAPI;
import com.polysocial.dto.ResponseDTO;
import com.polysocial.dto.ViewedStatusDTO;
import com.polysocial.service.ViewedStatusService;
import com.polysocial.utils.ValidateUtils;

@RestController
public class ViewedStatusController {
	
	@Autowired
	ViewedStatusService viewedStatusService;
	
	@PostMapping(ViewedStatusAPI.API_UPDATE_VIEWEDSTATUS)
	public ResponseEntity updateViewedStatus(@RequestBody ViewedStatusDTO dto) {
		if (ValidateUtils.isNullOrEmpty(dto.getContactId())) {
			ResponseDTO response = new ResponseDTO();
			response.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(viewedStatusService.updateViewedStatus(dto));
		}
	}
	
	@PostMapping(ViewedStatusAPI.API_UPDATE_All_VIEWEDSTATUS)
	public ResponseEntity updateAllViewedStatus(@RequestBody ViewedStatusDTO dto) {
		if (ValidateUtils.isNullOrEmpty(dto.getUserId())) {
			ResponseDTO response = new ResponseDTO();
			response.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(viewedStatusService.updateAllViewedStatus(dto));
		}
	}
}
