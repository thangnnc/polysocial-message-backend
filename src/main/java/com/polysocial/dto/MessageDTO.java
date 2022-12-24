package com.polysocial.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
public class MessageDTO implements Serializable {
	
    private Long messageId;

    private String content;

    private Boolean status;

    private LocalDateTime createdDate;
    
    private Long contactId;
    
    private Long roomId;
    
    private Long listcontactId[];
}
