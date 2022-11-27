package com.polysocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polysocial.entity.Contacts;

public interface ContactRepository extends JpaRepository<Contacts, Long>{

}
