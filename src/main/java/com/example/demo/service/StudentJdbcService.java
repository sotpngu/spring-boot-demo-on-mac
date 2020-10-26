package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentJdbcService {
    int add(Student student);
    int update(Student student);
    int deleteBysno(String sno);
    List<Map<String, Object>> queryStudentListMap();
    Student queryStudentBySno(String sno);
}
