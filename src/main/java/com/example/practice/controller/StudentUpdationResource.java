package com.example.practice.controller;

import com.example.practice.payload.EditStudentPayload;
import com.example.practice.response.StudentResponse;
import com.example.practice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentUpdationResource {
    @Autowired
    StudentService studentService;

    @PatchMapping("/edit")
    public ResponseEntity<StudentResponse> editStudent(@Valid @RequestParam Integer id, @RequestBody EditStudentPayload editPayload){
        return studentService.editStudent(id,editPayload);
    }

}
