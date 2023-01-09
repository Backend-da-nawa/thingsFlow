package com.example.thingsFlow.controller;

import com.example.thingsFlow.validation.service.DeleteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class DeleteController {
    private DeleteService deleteService;

    @DeleteMapping("/board/{id}")
    public Long validatePassword(@PathVariable("id") long id, @RequestBody Map<String, Object> map) {
        return deleteService.validatePassword(id, map);
    }
}

