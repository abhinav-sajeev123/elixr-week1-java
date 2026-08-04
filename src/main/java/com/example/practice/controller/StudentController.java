package com.example.practice.controller;
import com.example.practice.model.Student;
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
public class StudentController {

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

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentResponse>> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/get")
    public ResponseEntity<StudentResponse> getStudentById(@RequestParam int id){
       return studentService.getStudentById(id);
    }

    @PatchMapping("/edit")
    public ResponseEntity<StudentResponse>editStudent(@Valid @RequestParam int id,@RequestBody EditStudentPayload editPayload){
       return studentService.editStudent(id,editPayload);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<StudentResponse>deleteStudent(@RequestParam int id){
        return studentService.deleteStudent(id);
    }
}
