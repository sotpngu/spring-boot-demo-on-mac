package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMybatisMapper;
import com.example.demo.service.StudentMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentMybatisServiceImp implements StudentMybatisService {
    @Autowired
    private StudentMybatisMapper studentMybatisMapper;

    @Override
    public int add(Student student) {
        return this.studentMybatisMapper.add(student);
    }

    @Override
    public int update(Student student) {
        return this.studentMybatisMapper.update(student);
    }

    @Override
    public int deleteBysno(String sno) {
        return this.studentMybatisMapper.deleteNBysno(sno);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return this.studentMybatisMapper.queryStudentBySno(sno);
    }


}
