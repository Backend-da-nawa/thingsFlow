package com.example.thingsFlow.entity;
import com.example.thingsFlow.dto.BoardDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
    private LocalDateTime time;


}
