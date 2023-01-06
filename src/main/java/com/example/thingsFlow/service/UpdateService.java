package com.example.thingsFlow.service;

import com.example.thingsFlow.dto.UpdateDTO;
import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;


@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long updateBoard(Long id,String password) throws Exception {
        try {
            Optional<Board> optional= boardRepository.findById(id);
            Board oldBoard;
            if(optional.isPresent()){
                oldBoard=optional.get();
            } else  throw  new Exception();


            UpdateDTO updateDTO = UpdateDTO.builder()
                    .id(id)
                    .title()
                    .password(password)
                    .build();
            Board newBoard= Board.builder().updateDTO(updateDTO).build();
            boardRepository.save(newBoard);

        } catch (IllegalArgumentException e) {
            throw new IllegalAccessException("에러메세지");
        }
        return 1L;
    }



}
