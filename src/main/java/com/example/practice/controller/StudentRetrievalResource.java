package com.example.practice.controller;

import com.example.practice.response.StudentResponse;
import com.example.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRetrievalResource {

    @Autowired
    StudentService studentService;

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentResponse>> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/get")
    public ResponseEntity<StudentResponse> getStudentById(@RequestParam Integer id){
        return studentService.getStudentById(id);
    }
}
