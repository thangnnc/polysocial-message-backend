package com.polysocial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Message implements Serializable {

    private String mess1;

    private String mess2;

    private String mess3;

    private String mess4;
}
