package com.example.thingsFlow.service;

import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.repository.BoardRepository;
import com.example.thingsFlow.validation.DeleteValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DeleteService {

    private final BoardRepository boardRepository;
    private final DeleteValidation deleteValidation;

    @Transactional
    public Board validatePassword(Long id, Map map){
        Board board = getBoard(id);
        String oldPassword = board.getPassword();
        deleteValidation.validatePassword(map, oldPassword);
        boardRepository.delete(board);
        return board;
    }

    private Board getBoard(Long id){
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다. id=" + id));
    }

}
