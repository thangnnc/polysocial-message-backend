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

	@Query(value = "DECLARE @PageNumber AS bigint\n"
			+ "DECLARE @RowsOfPage AS bigint\n"
			+ "SET @PageNumber= ?1\n"
			+ "SET @RowsOfPage= ?2\n"
			+ "SELECT c.isAdmin, u.studentCode , u.fullName, u.avatar , m.content, m.createdDate, m.statusCreated, u.email,m.messageRecall  \n"
			+ "FROM Messages m\n"
			+ "    JOIN Contacts c on m.contactId = c.contactId JOIN Users u on c.userId = u.userId\n"
			+ "    JOIN RoomChats r on r.roomId = c.roomId\n"
			+ "WHERE r.roomId= ?3 AND m.status =1\n"
			+ "ORDER by m.createdDate DESC\n"
			+ "OFFSET (@PageNumber-1)*@RowsOfPage ROWS\n"
			+ "FETCH NEXT @RowsOfPage ROWS ONLY", nativeQuery = true)
	List<Object[]> findMessageAll(Long page,Long limit,Long roomId);

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
