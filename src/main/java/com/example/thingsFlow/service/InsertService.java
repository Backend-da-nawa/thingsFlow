package com.example.thingsFlow.service;

import com.example.thingsFlow.dto.InsertDTO;
import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.repository.BoardRepository;
import com.example.thingsFlow.parser.WeatherAPIParser;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("boardService")
@AllArgsConstructor
public class InsertService {
    private final BoardRepository boardRepository;

    private String hashingPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private boolean checkHashedPassword(String hashedPassword, String storedPassword) {
        return BCrypt.checkpw(hashedPassword, storedPassword);
    }

    @Transactional
    public Board insert(InsertDTO insertDTO) {
        InsertDTO dto = getDTO(insertDTO);
        Board board = new Board(dto);
        boardRepository.save(board);
        return board;
    }

    private InsertDTO getDTO(InsertDTO insertDTO) {
        WeatherAPIParser weatherAPIParser = WeatherAPIParser.getInstance();
        String weather = weatherAPIParser.getCurrentWeather();
        return InsertDTO.builder()
                .title(insertDTO.getTitle())
                .content(insertDTO.getContent())
                .password(insertDTO.getPassword())
                .weather(weather).build();
    }
}