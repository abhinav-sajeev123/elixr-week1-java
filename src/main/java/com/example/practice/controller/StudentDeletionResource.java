package com.example.practice.controller;

import com.example.practice.response.GenericResponse;
import com.example.practice.response.StudentResponse;
import com.example.practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentDeletionResource {

    private final StudentService studentService;

    @DeleteMapping("/delete")
    public ResponseEntity<GenericResponse<StudentResponse>> deleteStudent(@RequestParam Integer id){
        return studentService.deleteStudent(id);
    }
}
