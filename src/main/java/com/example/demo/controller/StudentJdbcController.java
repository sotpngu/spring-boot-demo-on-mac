package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentJdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jdbc")
public class StudentJdbcController {

    @Autowired
    private StudentJdbcService studentJdbcService;

    @RequestMapping(value = "/querystudent", method = RequestMethod.GET)
    public Student queryStudentBySno(String sno) {
        return this.studentJdbcService.queryStudentBySno(sno);
    }

    @RequestMapping(value = "/queryallstudent", method = RequestMethod.GET)
    public List<Map<String, Object>> queryAllStudent() {
        return this.studentJdbcService.queryStudentListMap();
    }

    @RequestMapping(value = "/addstudent", method = RequestMethod.GET)
    public int saveStudent(String sno,String name,String sex) {
        Student student = new Student();
        student.setSno(sno);
        student.setName(name);
        student.setSex(sex);
        return this.studentJdbcService.add(student);
    }

    @RequestMapping(value = "deletestudent", method = RequestMethod.GET)
    public int deleteStudentBySno(String sno) {
        return this.studentJdbcService.deleteBysno(sno);
    }
}
