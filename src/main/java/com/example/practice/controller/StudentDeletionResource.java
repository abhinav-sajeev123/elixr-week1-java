package com.example.practice.controller;

import com.example.practice.response.StudentResponse;
import com.example.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentDeletionResource {
    @Autowired
    StudentService studentService;

    @DeleteMapping("/delete")
    public ResponseEntity<StudentResponse> deleteStudent(@RequestParam Integer id){
        return studentService.deleteStudent(id);
    }
}
