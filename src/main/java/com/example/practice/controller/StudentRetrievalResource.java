package com.example.practice.controller;

import com.example.practice.response.GenericResponse;
import com.example.practice.response.StudentResponse;
import com.example.practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentRetrievalResource {

    private final StudentService studentService;

    @GetMapping("/getAll")
    public ResponseEntity<GenericResponse<List<StudentResponse>>> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/get")
    public ResponseEntity<GenericResponse<StudentResponse>> getStudentById(@RequestParam Integer id){
        return studentService.getStudentById(id);
    }
}
