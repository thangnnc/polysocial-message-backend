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
			+ "  JOIN Contacts c on m.contactId = c.contactId\n" + "  JOIN Users u on c.userId = u.userId\n"
			+ "  JOIN RoomChats r on r.roomId = c.roomId\n" + "  WHERE r.roomId= ?1\n"
			+ "  ORDER by m.createdDate", nativeQuery = true)
	List<Object[]> findMessageAll(Long roomId);

	@Query(value = "Select r.roomId, g.name,g.avatar,r.LastMessage,g.totalMember,r.lastUpDateDate, v.status from RoomChats r\n"
			+ "			JOIN Groups g on g.groupId = r.groupId\n"
			+ "			JOIN Contacts c on r.roomId = c.roomId\n"
			+ "			JOIN Users u on c.userId = u.userId\n"
			+ "            JOIN ViewedStatus v on v.contactId = c.contactId\n"
			+ "			WHERE u.userId=?1\n"
			+ "			GROUP BY r.roomId,g.name,r.lastMessage,r.LastUpDateDate, g.avatar,g.totalMember, v.status\n"
			+ "			ORDER by r.LastUpDateDate DESC", nativeQuery = true)
	List<Object[]> getNameGroupDESC(Long userId);

}
