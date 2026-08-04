package com.example.practice.controller;
import com.example.practice.payload.EditStudentPayload;
import com.example.practice.payload.StudentPayload;
import com.example.practice.response.StudentResponse;
import com.example.practice.service.StudentService;
import com.example.practice.validation.V1Validation;
import com.example.practice.validation.V2Validation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentCreationResource {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/add",headers="API-VERSION=1")
    public ResponseEntity<StudentResponse> addStudentV1(@Validated(V1Validation.class) @RequestBody StudentPayload studentPayload){
        return studentService.addStudent(studentPayload);
    }

    @PostMapping(value="/add",headers = "API-VERSION=2")
    public ResponseEntity<StudentResponse> addStudentV2(@Validated(V2Validation.class) @RequestBody StudentPayload studentPayload){
        return studentService.addStudent(studentPayload);
    }
}
