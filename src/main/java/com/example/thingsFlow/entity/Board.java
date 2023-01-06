package com.example.thingsFlow.entity;
import com.example.thingsFlow.dto.UpdateDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String password;

    @CreationTimestamp
    private LocalDateTime createTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    @Builder
    public Board(UpdateDTO updateDTO) {
        this.id = getId();
        this.title=getTitle();
        this.content=getContent();
        this.password=getPassword();
    }


}