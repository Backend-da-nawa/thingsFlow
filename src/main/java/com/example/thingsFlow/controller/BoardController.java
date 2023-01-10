package com.example.thingsFlow.controller;

import com.example.thingsFlow.dto.InsertDTO;
import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@Api(value = "hello", tags = {"API"})
@RestController("boardController")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @ApiOperation(value = "insert 기능 API", notes = "BCrypt 함수로 비밀번호를 해싱하고 오픈 API를 통해 받아온 날씨 정보를 추가")
    @PostMapping(value = "/api/insert")
    public Board insert(@RequestBody InsertDTO insertDTO) {
        String inputPassword = insertDTO.getPassword();
        String reg = "^[A-Za-z[0-9]]{6,}$";

        if (Pattern.matches(reg, inputPassword))
            return boardService.insert(insertDTO);

        return null;
    }

    @GetMapping("/api/hello")
    public String test() {
        return "hello";
    }
}