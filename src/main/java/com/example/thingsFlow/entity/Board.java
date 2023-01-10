package com.example.thingsFlow.entity;

import com.example.thingsFlow.dto.InsertDTO;
import com.example.thingsFlow.dto.LoadDTO;
import com.example.thingsFlow.dto.UpdateDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Table
@Getter
@EntityListeners(AuditingEntityListener.class)
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

    @Column
    private String weather;

    @CreatedDate
    @Column
    private LocalDateTime createdTime;

    @LastModifiedDate
    @Column
    private LocalDateTime updatedTime;

    @Builder
    public Board(UpdateDTO updateDTO) {
        this.id = updateDTO.getId();
        this.title = updateDTO.getTitle();
        this.content = updateDTO.getContent();
        this.password = updateDTO.getPassword();
    }

    public Board(InsertDTO insertDTO) {
        this.title = insertDTO.getTitle();
        this.content = insertDTO.getContent();
        this.password = BCrypt.hashpw(insertDTO.getPassword(), BCrypt.gensalt());
        this.weather = insertDTO.getWeather();
    }

    public void update(UpdateDTO updateDTO) {
        this.title = updateDTO.getTitle();
        this.content = updateDTO.getContent();
    }
}
