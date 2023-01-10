package com.example.thingsFlow.service;

import com.example.thingsFlow.dto.UpdateDTO;
import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.repository.BoardRepository;
import com.example.thingsFlow.validation.UpdateValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UpdateService {
    private final BoardRepository boardRepository;
    private final UpdateValidation updateValidation;
    @Transactional
    public Board updateBoard(UpdateDTO updateDTO) {
        Board board = boardRepository.findById(updateDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + updateDTO.getId()));

        updateValidation.validatePassword(board, updateDTO);

        board.update(updateDTO);
        return board;
    }
    @Transactional
    public Long validatePassword(Long id, Map map) {
        String oldPassword = getBoard(id).getPassword();

        updateValidation.validatePassword(map, oldPassword);

        return 1L;
    }

    private Board getBoard(Long id) {
        Optional<Board> optional = boardRepository.findById(id);
        Board oldBoard;
        if (optional.isPresent()) {
            oldBoard = optional.get();
        } else throw new IllegalArgumentException("[ERROR] 해당하는 게시글이 없습니다.");
        return oldBoard;
    }
}
