package com.example.thingsFlow.dto;

import lombok.*;

@NoArgsConstructor
@Data
public class UpdateDTO {
    private Long id;
    private String title;
    private String content;
    private String password;

    @Builder
    public UpdateDTO(Long id,String title, String content, String password) {
        this.id=id;
        this.title = title;
        this.content = content;
        this.password = password;
    }
}
