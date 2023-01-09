package com.example.thingsFlow.dto;

import com.example.thingsFlow.entity.Board;
import lombok.*;

@Data
public class BoardDTO {
    private Long id;
    private String title;
    private String content;
    private String password;
    private String weather;
    private String uploaded;


    @Builder
    public BoardDTO(Long id, String title, String content, String password) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.password = password;
    }
}
