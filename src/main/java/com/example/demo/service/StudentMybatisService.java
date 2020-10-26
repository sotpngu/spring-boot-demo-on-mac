package com.example.demo.service;

import com.example.demo.entity.Student;

public interface StudentMybatisService {
    int add(Student student);
    int update(Student student);
    int deleteBysno(String sno);
    Student queryStudentBySno(String sno);
}
