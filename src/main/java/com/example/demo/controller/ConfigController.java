package com.example.demo.controller;

import com.example.demo.config.GmhConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @Autowired
    private GmhConfigBean gmhConfigBean;

    @GetMapping("/gmhConfig")
    public String gmhConfig() {
        return gmhConfigBean.getAge() + "---" + gmhConfigBean.getMarried();
    }
}
