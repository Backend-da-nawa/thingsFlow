package com.example.thingsFlow.controller;

import com.example.thingsFlow.validation.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {
    private BoardService boardService;

    @DeleteMapping("/post/delete/{id}")
    public Long delete(@PathVariable("id") long id, @RequestParam("password") String password){
        boolean deleteCheckFlag = boardService.boardDelete(id, password);
        if(deleteCheckFlag == false){
            System.out.println("비밀번호가 일치하지 않습니다");
            return 1L;
        }
        return 2L;
    }
}
