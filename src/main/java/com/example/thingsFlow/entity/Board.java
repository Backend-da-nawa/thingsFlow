package com.example.thingsFlow.entity;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Table
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;
    private String password;

    @CreationTimestamp
    private LocalDateTime time;
}
