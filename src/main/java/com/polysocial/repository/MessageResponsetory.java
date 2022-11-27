package com.polysocial.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.polysocial.entity.Messages;

@Service
public interface MessageResponsetory extends JpaRepository<Messages, Long> {

	@Query(value = "SELECT c.isAdmin,u.studentCode ,u.fullName,u.avatar ,m.content, m.createdDate FROM Messages m\n"
			+ "  JOIN Contacts c on m.contactId = c.contactId\n"
			+ "  JOIN Users u on c.userId = u.userId\n"
			+ "  JOIN RoomChats r on r.roomId = c.roomId\n"
			+ "  WHERE r.roomId= :roomId\n"
			+ "  ORDER by m.createdDate", nativeQuery = true)
	List<Object[]> findMessageAll( Long roomId);
	
}
