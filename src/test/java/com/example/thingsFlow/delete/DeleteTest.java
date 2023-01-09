package com.example.thingsFlow.delete;


import com.example.thingsFlow.dto.BoardDTO;
import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.repository.BoardRepository;
import org.junit.After;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("게시판 테스트")
public class DeleteTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BoardRepository boardRepository;
    @After
    public void clear() {
        boardRepository.deleteAll();
    }


    @Test
    public void 게시판_글_삭제(){

        Board savedBoard = boardRepository.save(Board.builder()
                .id(1L)
                .title("인사드립니다")
                .content("안녕하세요 만나서 반갑습니다.")
                .password("1234")
                .build());


        String url = "http://localhost:" + port + "/board/{id}";

        UriComponents uri = UriComponentsBuilder.fromUriString(url).encode().build();
        restTemplate.delete(uri.toUri());

        List<Board> deleted =boardRepository.findAll();
        assertThat(deleted.size()).isEqualTo(0);
    }
}
