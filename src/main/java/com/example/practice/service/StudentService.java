package com.example.practice.service;

import com.example.practice.model.Student;
import com.example.practice.payload.StudentPayload;
import com.example.practice.response.StudentResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    ResponseEntity<StudentResponse> addStudent(StudentPayload studentPayload);

    ResponseEntity<List<Student>> getStudents();
}
    
