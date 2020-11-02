package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filterAndInterceptor")
public class FilterAndInterceptorController {

    @GetMapping("/{id:\\d+}")
    public String get(@PathVariable String id) {
        System.out.println(id);
        return id;
    }

}
