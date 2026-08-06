package com.example.practice.controller;

import com.example.practice.payload.EditStudentPayload;
import com.example.practice.response.GenericResponse;
import com.example.practice.response.StudentResponse;
import com.example.practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentUpdationResource {

    private final StudentService studentService;

    @PatchMapping( "/edit")
    public ResponseEntity<GenericResponse<StudentResponse>> editStudentV1(@RequestParam Integer id, @RequestBody EditStudentPayload editPayload){
        return studentService.editStudent(id,editPayload);
    }
}
