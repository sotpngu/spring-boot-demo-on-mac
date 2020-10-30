package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentMybatisService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mybatis")
public class StudentMybatisController {
    @Autowired
    private StudentMybatisService studentMybatisService;

    @RequestMapping(value = "/querystudent", method = RequestMethod.GET)
    public Student queryStudentBySno(@Param(value = "sno") String sno) {
        return this.studentMybatisService.queryStudentBySno(sno);
    }

    @PostMapping("/queryAllStudent")
    public PageInfo<Student> queryAllStudent(@RequestParam("pageNumber") Integer pageNumber,@RequestParam("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Student> students = this.studentMybatisService.queryAllStudent();
        PageInfo<Student> pageStudents = new PageInfo<>(students);
        return pageStudents;
    }
}

// http://localhost:8088/mybatis/querystudent?sno=003
