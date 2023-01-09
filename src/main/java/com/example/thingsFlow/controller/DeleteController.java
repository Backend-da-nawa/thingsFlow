package com.example.thingsFlow.controller;

import com.example.thingsFlow.service.DeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class DeleteController {
    private final DeleteService deleteService;

    @DeleteMapping("/board/{id}")
    public Long validatePassword(@PathVariable("id") long id, @RequestBody Map<String, Object> map) {
        return deleteService.validatePassword(id, map);
    }
}

