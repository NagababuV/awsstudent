package com.example.student;

import com.example.student.controller.StudentController;
import com.example.student.model.Student;
import com.example.student.repository.StudentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")


public class ControllerTest {



    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private StudentController studentController;

    @BeforeEach
    public void setUP(){

        Student student = new Student();
        student.setId("1");
        student.setMailId("nagababu.vegisetti@gmail.com");
        student.setName("NagaBabu");
        student.setRegistrationNo(66);
        studentRepo.save(student);
    }

    @Test
    public void  testGetUserByStudentId(){

        Student student = studentController.getStudentById("1");
        assertNotNull(student);
        assertEquals("NagaBabu",student.getName());
        assertEquals("nagababu.vegisetti@gmail.com", student.getMailId());



    }
}
