package com.example.demo.mapper;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface StudentMybatisMapper {
    @Insert("insert into tb_student(sno,name,sex) values(#{sno},#{name},#{sex})")
    int add(Student student);

    @Update("update tb_student set name=#{name},sex=#{sex} where sno=#{sno}")
    int update(Student student);

    @Delete("delete from tb_student where sno=#{sno}")
    int deleteNBysno(String sno);

    @Select("select * from tb_student where sno=#{sno}")
    @Results(id = "student", value = {
            @Result(property = "sno", column = "sno", javaType = String.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "sex", column = "sex", javaType = String.class),
    })
    Student queryStudentBySno(String sno);
}
