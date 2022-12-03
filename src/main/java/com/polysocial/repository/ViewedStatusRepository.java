package com.polysocial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.polysocial.dto.ViewedStatusDTO;
import com.polysocial.entity.ViewedStatus;

@Service
public interface ViewedStatusRepository extends JpaRepository<ViewedStatus, Long>{
	
	@Query(value = "update ViewedStatus set status =1 WHERE contactId=?1", nativeQuery = true)
	public ViewedStatusDTO updateViewedStatus(Long contactId); 
	
	@Query(value = "update ViewedStatus set status =0 WHERE contactId=?1", nativeQuery = true)
	ViewedStatus updateViewedFALSE(Long contactId);
}
