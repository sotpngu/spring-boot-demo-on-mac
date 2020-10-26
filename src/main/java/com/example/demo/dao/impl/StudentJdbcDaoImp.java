package com.example.demo.dao.impl;

import com.example.demo.dao.StudentJdbcDao;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentJdbcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class StudentJdbcDaoImp implements StudentJdbcDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Student student) {
        String sql = "insert into tb_student(sno,name,sex) values(:sno,:name,:sex)";
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        return npjt.update(sql, new BeanPropertySqlParameterSource(student));
    }

    @Override
    public int update(Student student) {
        String sql = "update tb_student set name = ?,sex = ? where sno = ?";
        Object[] args = {
                student.getName(),
                student.getSex(),
                student.getSno()
        };
        int[] argTypes = {
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR
        };
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public int deleteBysno(String sno) {
        String sql = "delete from tb_student where sno = ?";
        Object[] args = {
                sno
        };
        int[] argTypes = {
                Types.VARCHAR
        };
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public List<Map<String, Object>> queryStudentsListMap() {
        String sql = "select * from tb_student";
        return this.jdbcTemplate.queryForList(sql);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        String sql = "select * from tb_student where sno = ?";
        Object[] args = {
                sno
        };
        int[] argTypes = {
                Types.VARCHAR
        };
        List<Student> studentList = this.jdbcTemplate.query(sql, args, argTypes, new StudentJdbcMapper());
        if (studentList != null && studentList.size() > 0) {
            return studentList.get(0);
        } else {
            return null;
        }
    }
}
