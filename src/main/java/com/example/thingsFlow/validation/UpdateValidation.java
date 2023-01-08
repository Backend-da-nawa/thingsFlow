package com.example.thingsFlow.validation;

import com.example.thingsFlow.dto.UpdateDTO;
import com.example.thingsFlow.entity.Board;
import com.example.thingsFlow.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UpdateValidation {

    public void validatePassword(Board oldBoard, UpdateDTO updateDTO){
      if(updateDTO.getPassword().equals(oldBoard.getPassword())){
      }
      else {
          throw new IllegalArgumentException("비밀번호가 틀렸습니다");
      }

    }

    public void validatePassword(Map map, String oldPassword){
        if(oldPassword.equals(map.get("password"))){
        }
        else {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다");
        }

    }
}
