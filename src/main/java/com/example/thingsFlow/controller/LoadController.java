package com.example.thingsFlow.controller;

import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.service.LoadService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoadController {

    private LoadService loadService;

    @GetMapping("/load")
    public Page<Board> load(final Pageable pageable) {
        return loadService.load(pageable);
    }
}
