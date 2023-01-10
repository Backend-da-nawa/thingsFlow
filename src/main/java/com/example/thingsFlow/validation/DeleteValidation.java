package com.example.thingsFlow.validation;

import com.example.thingsFlow.entity.Board;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DeleteValidation {

    public void validatePassword(Map map, String oldPassword){
        if(!oldPassword.equals(map.get("password"))){
            throw new IllegalArgumentException("비밀번호가 틀렸습니다");
        }
    }
}
