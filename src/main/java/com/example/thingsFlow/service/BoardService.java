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
public class BoardService {
    private final BoardRepository boardRepository;

    private String hashingPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private boolean checkHashedPassword(String hashedPassword, String storedPassword) {
        return BCrypt.checkpw(hashedPassword, storedPassword);
    }

    @Transactional
    public InsertDTO insert(InsertDTO insertDTO) {
        WeatherAPIParser weatherAPIParser = WeatherAPIParser.getInstance();
        String weather = weatherAPIParser.getCurrentWeather();

        Board board = new Board(
                insertDTO.getTitle(),
                insertDTO.getContent(),
                hashingPassword(insertDTO.getPassword()),
                weather
        );

        boardRepository.save(board);
        return new InsertDTO(board);
    }
}