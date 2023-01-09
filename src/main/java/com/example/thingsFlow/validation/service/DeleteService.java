package com.example.thingsFlow.validation.service;

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
        String oldPassword=getBoard(id).getPassword();
        deleteValidation.validatePassword(map,oldPassword);
        boardRepository.deleteById(id);
        return 1L;
    }

    private Board getBoard(Long id){
        Optional<Board> optional=boardRepository.findById(id);
        Board oldBoard;
        if(optional.isPresent()){
            oldBoard=optional.get();
        }else throw new IllegalArgumentException("[ERROR] 존재하지 않는 게시물입니다");
        return oldBoard;
    }
    
}
