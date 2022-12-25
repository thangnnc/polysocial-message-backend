package com.polysocial.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "`Messages`")
public class Messages implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    private String content;

    private Boolean status;
    
    private Boolean statusCreated;

    private LocalDateTime createdDate;
    
    private Long contactId;
    
    private Boolean messageRecall;
}
