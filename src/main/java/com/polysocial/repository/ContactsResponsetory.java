package com.polysocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.polysocial.entity.Contacts;

@Service
public interface ContactsResponsetory extends JpaRepository<Contacts, Long> {

	@Query(value = "select c.contactId,u.studentCode,u.avatar,u.fullName from Contacts c\n"
			+ "JOIN Users u on u.userId = c.userId\n"
			+ "WHERE c.roomId=?1", nativeQuery = true)
	List<Object[]> getContactByRoomId(Long roomId);
}
