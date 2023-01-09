package com.example.thingsFlow.dto;

import com.example.thingsFlow.entity.Board;
import lombok.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Data
public class InsertDTO {
    private String title;
    private String content;
    private String password;
    private String weather;
    private String uploaded;

    public InsertDTO(Board board) {
        this(board.getTitle(), board.getContent(), board.getPassword(), board.getWeather(), board.getUpdatedTime().toString());
    }

    @Builder
    public InsertDTO(String title, String content, String password, String weather, String uploaded) {
        this.title = title;
        this.content = content;
        this.password = password;
        this.weather = weather;
        this.uploaded = uploaded;
    }
}