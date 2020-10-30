package com.example.demo.controller;

import com.example.demo.helper.SpringLoggingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogbackController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/logback")
    public String logback() {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        new SpringLoggingHelper().helpMethod();
        return "Logbakc";
    }
}
