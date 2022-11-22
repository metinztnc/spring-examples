package org.metindev.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document
@Data
@Builder
public class User {
    @Id
    private String id;
    private String name;
    private String surName;
    private HashMap properties;

}
