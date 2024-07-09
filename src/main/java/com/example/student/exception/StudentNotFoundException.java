package com.example.student.exception;


public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String id){
        super("Could not found the user with id "+id);

    }
}
