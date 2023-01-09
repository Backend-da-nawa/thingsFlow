package com.example.thingsFlow.service;

import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.repository.BoardRepository;
import com.example.thingsFlow.validation.DeleteValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteService {

    private final BoardRepository boardRepository;
    private final DeleteValidation deleteValidation;

    @Transactional
    public Long validatePassword(Long id, Map map){
        String oldPassword = getBoard(id).getPassword();
        deleteValidation.validatePassword(map, oldPassword);
        boardRepository.deleteById(id);
        return 1L;
    }

    private Board getBoard(Long id){
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다. id=" + id));
    }
    
}
