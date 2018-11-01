package com.rckj.dao;

import com.rckj.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testSaveStudent(){
        Student student = new Student();
        student.setId(1);
        student.setName("haowen");
        student.setAge(12);
        student.setSex("nan");

        studentDao.saveStudent(student);
    }

    @Test
    public void findStudentByName(){
        Student student = studentDao.findStudentByStudentName("haowen");
        System.out.println("+++++++++"+student.toString());
    }
}
