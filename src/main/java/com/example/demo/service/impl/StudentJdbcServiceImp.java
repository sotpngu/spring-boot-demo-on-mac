package com.example.demo.service.impl;

import com.example.demo.dao.StudentJdbcDao;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentJdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Struct;
import java.util.List;
import java.util.Map;

@Service
public class StudentJdbcServiceImp implements StudentJdbcService {

    @Autowired
    private StudentJdbcDao studentJdbcDao;

    @Override
    public int add(Student student) {
        return this.studentJdbcDao.add(student);
    }

    @Override
    public int update(Student student) {
        return this.studentJdbcDao.update(student);
    }

    @Override
    public int deleteBysno(String sno) {
        return this.studentJdbcDao.deleteBysno(sno);
    }

    @Override
    public List<Map<String, Object>> queryStudentListMap() {
        return this.studentJdbcDao.queryStudentsListMap();
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return this.studentJdbcDao.queryStudentBySno(sno);
    }

}
