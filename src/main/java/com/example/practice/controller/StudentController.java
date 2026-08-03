package com.example.practice.controller;

import com.example.practice.model.Student;
import com.example.practice.payload.EditStudentPayload;
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
    public ResponseEntity<List<StudentResponse>> getStudents(){
        return studentService.getStudents();
    }

    @PutMapping("/edit")
    public ResponseEntity<StudentResponse>editStudent(@RequestParam int id,@RequestBody EditStudentPayload editPayload){
       return studentService.editStudent(id,editPayload);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<StudentResponse>deleteStudent(@RequestParam int id){
        return studentService.deleteStudent(id);
    }
}
