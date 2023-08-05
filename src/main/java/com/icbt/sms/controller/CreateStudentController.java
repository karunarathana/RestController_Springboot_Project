package com.icbt.sms.controller;

import com.icbt.sms.entities.StudentEntity;
import com.icbt.sms.entities.StudentRequestEntity;
import com.icbt.sms.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreateStudentController {

    private final Logger logger = LoggerFactory.getLogger(CreateStudentController.class);

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public StudentEntity crateStudent(@RequestBody @Validated StudentRequestEntity studentRequestEntity) {
        logger.info("Request started in crateStudent");
        //Call Service class
        StudentEntity student = studentService.createStudent(studentRequestEntity);
        logger.info("Request completed in create student | response = {}", student);
        return student;
    }

    @GetMapping("/student/{id}")
    public StudentEntity getStudentById(@PathVariable Long id)
    {
        logger.info("Request started in getStudentById | id={}",id);
        StudentEntity studentResponse = studentService.getStudentById(id);
        logger.info("Response completed in getStudent | response ={}",studentResponse);
        return studentResponse;

    }

    @GetMapping("/student")
    public List<StudentEntity> getStudent()
    {
        logger.info("Request started in getStudent");
        List<StudentEntity> students = studentService.getStudent();
        logger.info("Response completed in getStudent");
        return students;
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable Long id)
    {
        logger.info("Request started in deleteStudent | id={}",id);
        String response = studentService.deleteStudentById(id);
        logger.info("Response completed in getStudent | response ={}",response);
        return response;
    }

    @PatchMapping("/student")
    public StudentEntity updateStudent(@RequestBody StudentEntity studentEntity)
    {
        logger.info("Request started in updateStudent");
        StudentEntity updateStudent = studentService.updateStudent(studentEntity);
        logger.info("Request completed in updateStudent | response = {}",updateStudent );
        return updateStudent;
    }

}
