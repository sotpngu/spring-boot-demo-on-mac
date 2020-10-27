package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentMybatisService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentMybatisController {
    @Autowired
    private StudentMybatisService studentMybatisService;

    @RequestMapping(value = "/querystudent", method = RequestMethod.GET)
    public Student queryStudentBySno(@Param(value = "sno") String sno) {
        return this.studentMybatisService.queryStudentBySno(sno);
    }
}

// http://localhost:8088/querystudent?sno=003
