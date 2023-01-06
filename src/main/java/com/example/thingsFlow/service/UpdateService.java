package com.example.thingsFlow.service;

import com.example.thingsFlow.dto.UpdateDTO;
import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.repository.BoardRepository;
import com.example.thingsFlow.validation.UpdateValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UpdateService {
    @Autowired
    private final BoardRepository boardRepository;

    @Autowired
    private final UpdateValidation updateValidation;

    @Transactional
    public Long updateBoard(UpdateDTO updateDTO) throws Exception {
        try {
            Optional<Board> optional = boardRepository.findById(updateDTO.getId());
            Board oldBoard;
            if (optional.isPresent()) {
                oldBoard = optional.get();
            } else throw new Exception();

            updateValidation.validatePassword(oldBoard, updateDTO);

            UpdateDTO newDTO = UpdateDTO.builder()
                    .id(oldBoard.getId())
                    .title(updateDTO.getTitle())
                    .content(updateDTO.getContent())
                    .password(oldBoard.getPassword())
                    .build();
            Board newBoard = Board.builder().updateDTO(newDTO).build();
            boardRepository.save(newBoard);

        } catch (IllegalArgumentException e) {
            throw new IllegalAccessException("에러메세지");
        }
        return 1L;
    }
    @Transactional
    public Long validatePassword(Long id, Map map) throws Exception {
        try {
            Optional<Board> optional = boardRepository.findById(id);
            Board oldBoard;
            if (optional.isPresent()) {
                oldBoard = optional.get();
            } else throw new Exception();
            String oldPassword=oldBoard.getPassword();

            updateValidation.validatePassword(id,map,oldPassword);

        } catch (IllegalArgumentException e) {
            throw new IllegalAccessException("에러메세지");
        }
        return 1L;
    }
}
