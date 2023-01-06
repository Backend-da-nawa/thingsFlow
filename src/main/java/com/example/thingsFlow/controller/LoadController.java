package com.example.thingsFlow.controller;

import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.service.LoadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api"))
@AllArgsConstructor
@Api(tags = {"api"}, value = "게시글 조회 API 정보를 제공하는 Controller")
public class LoadController {

    private LoadService loadService;

    @GetMapping("/load")
    @ApiOperation(value = "조회할 게시글을 페이지로 반환하는 메서드")
    public Slice<Board> load(final Pageable pageable) {
        return loadService.load(pageable);
    }
}