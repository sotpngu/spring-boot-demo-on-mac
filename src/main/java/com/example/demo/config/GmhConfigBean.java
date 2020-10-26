package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

// 自定义配置文件
@Data
@Configuration
@ConfigurationProperties(prefix = "gmh")
@PropertySource("classpath:gaominghao.properties")
@Component
public class GmhConfigBean {
    private Integer age;
    private Boolean married;
}
