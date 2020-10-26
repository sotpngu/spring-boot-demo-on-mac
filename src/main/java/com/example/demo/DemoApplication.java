package com.example.demo;


import com.example.demo.config.GmhConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})  // same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableConfigurationProperties({GmhConfigBean.class}) // 自定义配置文件
public class DemoApplication {

	@RequestMapping("/hello")
	public String sayHello(@RequestParam(required = false, name = "who") String who) {
		if (StringUtils.isEmpty(who)) {
			who = "Worldsss";
		}
		return String.format("Hello, %s!", who);
	}

	public static void main(String[] args) {
//		项目的配置可以被命令行修改
//		SpringApplication.run(DemoApplication.class, args);
//		项目的配置不可以被命令行修改
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.setAddCommandLineProperties(false);
		app.run(args);
	}

}
