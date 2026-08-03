package com.example.practice.controller;

import com.example.practice.model.Student;
import com.example.practice.payload.StudentPayload;
import com.example.practice.response.StudentResponse;
import com.example.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentPayload studentPayload){
        return studentService.addStudent(studentPayload);

    }

    @GetMapping("/get")
    public ResponseEntity<List<Student>> getStudents(){
        return studentService.getStudents();
    }
}
