package com.example.thingsFlow.service;

import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class LoadService {

    private BoardRepository boardRepository;

    @Transactional
    public Page<Board> load(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }
}
