package com.example.thingsFlow.controller;

import com.example.thingsFlow.dto.UpdateDTO;
import com.example.thingsFlow.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
    private BoardService boardService;
    @GetMapping(value = "/post/update/{id}")
    public Long update(@PathVariable("id") long id, @RequestParam("password") String password) throws Exception{
        return boardService.updateBoard(id,password);
    }



}
