package com.example.thingsFlow.controller;

import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.service.DeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DeleteController {
    private final DeleteService deleteService;

    @DeleteMapping("/board/{id}")
    public Board validatePassword(@PathVariable("id") long id, @RequestBody Map<String, Object> map) {
        return deleteService.validatePassword(id, map);
    }
}

