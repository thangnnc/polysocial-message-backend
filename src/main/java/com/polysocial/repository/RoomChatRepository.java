package com.polysocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polysocial.entity.RoomChats;

public interface RoomChatRepository extends JpaRepository<RoomChats, Long>{

}
