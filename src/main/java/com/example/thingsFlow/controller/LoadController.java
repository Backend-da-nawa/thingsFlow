package com.example.thingsFlow.controller;

import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.service.LoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoadController {

    private LoadService loadService;

    @GetMapping("/load/{page}")
    public List<Board> load(@PathVariable int page) {

    }
}
