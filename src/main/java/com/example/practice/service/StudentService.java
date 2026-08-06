package com.example.practice.service;

import com.example.practice.payload.EditStudentPayload;
import com.example.practice.payload.StudentPayload;
import com.example.practice.response.GenericResponse;
import com.example.practice.response.StudentResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    ResponseEntity<GenericResponse<StudentResponse>> addStudent(StudentPayload studentPayload, String version);

    ResponseEntity<GenericResponse<List<StudentResponse>>> getStudents();

    ResponseEntity<GenericResponse<StudentResponse>> editStudent(Integer id, EditStudentPayload editPayload);

    ResponseEntity<GenericResponse<StudentResponse>> deleteStudent(Integer id);

    ResponseEntity<GenericResponse<StudentResponse>> getStudentById(Integer id);
}
    
