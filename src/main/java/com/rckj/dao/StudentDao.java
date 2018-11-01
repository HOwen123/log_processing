package com.rckj.dao;

import com.rckj.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveStudent(Student student){
        mongoTemplate.save(student);
    }

    public Student findStudentByStudentName(String name){
        Query query = new Query(Criteria.where("name").is(name));
        Student student = mongoTemplate.findOne(query,Student.class);
        return  student;
    }


}
