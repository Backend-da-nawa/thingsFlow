package com.example.thingsFlow.entity;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Table
public class Board {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(length = 20)
    private String title;

    @Column(length = 200)
    private String content;

    @Column
    private String password;

    @CreationTimestamp
    @Column
    private LocalDateTime time;
}
