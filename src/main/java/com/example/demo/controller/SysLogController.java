package com.example.demo.controller;

import com.example.demo.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysLogController {

    @Log("执行方法一")
    @GetMapping("/one")
    public String methodOne(String name) {
        return "methodOne run";
    }

    @Log("执行方法二")
    @GetMapping("/two")
    public String methodTwo() throws InterruptedException {
        Thread.sleep(2000);
        return "methodTwo run";
    }

    @Log("执行方法三")
    @GetMapping("/three")
    public String methodThree(String name, String age) {
        return "methodThree run";
    }
}

// 测试
// http://localhost:8088/one?name=KangKang
// http://localhost:8088/two
// http://localhost:8088/three?name=Mike&age=25
