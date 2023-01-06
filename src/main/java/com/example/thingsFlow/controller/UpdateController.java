package com.example.thingsFlow.controller;

import com.example.thingsFlow.dto.UpdateDTO;
import com.example.thingsFlow.service.UpdateService;
import com.example.thingsFlow.validation.UpdateValidation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
public class UpdateController {
    private UpdateService updateService;
    private UpdateValidation updateValidation;

    @PutMapping("/board/{id}")
    public Long validatePassword(@PathVariable("id") long id, @RequestBody Map<String,Object> map) throws Exception{
        return updateService.validatePassword(id,map);

    }


    @PutMapping ("/post")
    public Long update(@RequestBody UpdateDTO updateDTO) throws Exception{
        return updateService.updateBoard(updateDTO);
    }




}
