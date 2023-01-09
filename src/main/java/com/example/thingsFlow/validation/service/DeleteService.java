package com.example.thingsFlow.validation.service;

import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteService {

    private final BoardRepository boardRepository;

    @Transactional
    public boolean boardDelete(long id, String password) {
        Optional<Board> boardEntityWrapper = boardRepository.findById(id);
        if (boardEntityWrapper.isPresent()) {
            Board board = boardEntityWrapper.get();
            if (password.equalsIgnoreCase(board.getPassword())) {
                boardRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("존재하지 않는 게시글 삭제 시도");
            return false;
        }


    }
}
