package com.example.thingsFlow.entity;
import com.example.thingsFlow.dto.DeleteBoardDTO;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Board {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String password;

    @CreatedDate
    private LocalDateTime createdTme;

    @LastModifiedDate
    private LocalDateTime updatedTime;

    @Builder
    public Board(DeleteBoardDTO deleteBoardDTO) {
        this.id = deleteBoardDTO.getId();
        this.title = deleteBoardDTO.getTitle();
        this.content = deleteBoardDTO.getContent();
        this.password = deleteBoardDTO.getPassword();
    }


}
