package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentMybatisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class RedisTest {

    @Autowired
    private StudentMybatisService studentMybatisService;

    @Test
    public void test() throws Exception {
        Student student1 = this.studentMybatisService.queryStudentBySno("001");
        System.out.println("学号" + student1.getSno() + "的学生姓名为：" + student1.getName());

        Student student2 = this.studentMybatisService.queryStudentBySno("001");
        System.out.println("学号" + student2.getSno() + "的学生姓名为：" + student2.getName());
    }
}
