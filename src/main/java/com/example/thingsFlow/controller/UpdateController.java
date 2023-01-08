package com.example.thingsFlow.controller;

import com.example.thingsFlow.dto.UpdateDTO;
import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.service.UpdateService;
import com.example.thingsFlow.validation.UpdateValidation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UpdateController {
    private UpdateService updateService;

    @GetMapping("/board/{id}")
    public Long validatePassword(@PathVariable("id") long id, @RequestBody Map<String,Object> map) {
        return updateService.validatePassword(id, map);
    }

    @PutMapping ("/post")
    public Board update(@RequestBody UpdateDTO updateDTO) {
        return updateService.updateBoard(updateDTO);
    }
}
