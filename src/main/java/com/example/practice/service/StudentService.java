package com.example.practice.service;

import com.example.practice.payload.EditStudentPayload;
import com.example.practice.payload.StudentPayload;
import com.example.practice.response.StudentResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    ResponseEntity<StudentResponse> addStudent(StudentPayload studentPayload);

    ResponseEntity<List<StudentResponse>> getStudents();

    ResponseEntity<StudentResponse> editStudent(int id, EditStudentPayload editPayload);

    ResponseEntity<StudentResponse> deleteStudent(int id);

    ResponseEntity<StudentResponse> getStudentById(int id);
}
    
