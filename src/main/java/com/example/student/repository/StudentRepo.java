package com.example.student.repository;

import com.example.student.model.Student;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student,Long> {
}
