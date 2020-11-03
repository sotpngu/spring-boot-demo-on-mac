package com.example.demo.controller;

import com.example.demo.entity.ValidateLogin;
import com.example.demo.service.ValidateLoginModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ValidateLoginController {

    @ApiOperation("登录以后返回token")
    @PostMapping("/validateLogin")
    public Map<String, Object> login(@RequestBody @Validated(ValidateLoginModel.class) ValidateLogin validateLogin) {
        Map<String, Object> message = new HashMap<>();
        message.put("result", "成功");
        return message;
    }
}
