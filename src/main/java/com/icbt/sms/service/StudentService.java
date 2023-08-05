package com.icbt.sms.service;

import com.icbt.sms.entities.StudentEntity;
import com.icbt.sms.entities.StudentRequestEntity;
import com.icbt.sms.repositary.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;
    public StudentEntity createStudent(StudentRequestEntity studentRequestEntity)
    {
        logger.info("Method execution started createStudent");
        //Student validation
        validation(studentRequestEntity);
        //Convert request entity into StudentEntity

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentRequestEntity.getName());
        studentEntity.setAge(studentRequestEntity.getAge());
        studentEntity.setAddress(studentRequestEntity.getAddress());
        studentEntity.setMobileNumber(studentRequestEntity.getMobileNumber());
        studentEntity.setClassName(studentRequestEntity.getClassName());

        //save student
        StudentEntity response = studentRepository.save(studentEntity);
        logger.info("Method execution completed | response={}",response);
        return response;

    }

    private static void validation(StudentRequestEntity studentRequestEntity) {
        if(studentRequestEntity.getName().length()>=50)
        {
            throw new RuntimeException("Name should be less than 50 character");
        }
    }

    public StudentEntity getStudentById(Long id) {
        logger.info("Method execution started getStudent");
        Optional<StudentEntity> studentResponse = studentRepository.findById(id);
        if (studentResponse.isPresent())
        {
            return studentResponse.get();
        }
        logger.info("Method execution complete getStudent | response ={}",studentResponse.get());
        return null;

    }

    public List<StudentEntity> getStudent() {
        logger.info("Method execution started getStudent");
        List<StudentEntity> students = studentRepository.findAll();
        logger.info("Method execution complete getStudent | response ={}",students);
        return students;
    }

    public String deleteStudentById(Long id) {
        logger.info("Method execution started deleteStudentById");
        studentRepository.deleteById(id);
        logger.info("Method execution complete deleteStudentById");
        return "Delete Student Successfull";
    }

    public StudentEntity updateStudent(StudentEntity studentEntity) {
        logger.info("Method execution started updateStudent");
        StudentEntity updatedStudent = studentRepository.save(studentEntity);
        logger.info("Method execution completed | response={}",updatedStudent);
        return updatedStudent;
    }
}
