package com.example.student.controller;

import com.example.student.exception.StudentNotFoundException;
import com.example.student.model.Student;
import com.example.student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentRepo studentRepo;
    @PostMapping("/add")
    public Student newStudent(@RequestBody Student newStudent){
        return studentRepo.save(newStudent);


    }

    @GetMapping("/getall")
    public List<Student> getAll(){

        return studentRepo.findAll();

    }

    @GetMapping("/findById/{id}")
    public Student  getStudentById(@PathVariable String id){
        return studentRepo.findById(id)
        .orElseThrow(()->new StudentNotFoundException(id));

    }
    @PutMapping("/update/{id}")
    Student updateStudent(@RequestBody Student newStudent ,@PathVariable String id){
        return studentRepo.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    student.setRegistrationNo(newStudent.getRegistrationNo());
                    student.setMailId(newStudent.getMailId());
                    return  studentRepo.save(student);
                }).orElseThrow(()-> new StudentNotFoundException(id));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable String id){

        if(!studentRepo.existsById(id)){
            throw new StudentNotFoundException(id);
        }
        studentRepo.deleteById(id);

        return "Entered id details has been deleted";


    }
}
