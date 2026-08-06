package com.example.practice.controller;
import com.example.practice.header_constants.ApiConstants;
import com.example.practice.payload.StudentPayload;
import com.example.practice.response.GenericResponse;
import com.example.practice.response.StudentResponse;
import com.example.practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentCreationResource {

    private final StudentService studentService;

    @PostMapping(value = "/add",produces = ApiConstants.STUDENT_V1)
    public ResponseEntity<GenericResponse<StudentResponse>> addStudentV1(@RequestBody StudentPayload studentPayload){
        return studentService.addStudent(studentPayload, ApiConstants.STUDENT_V1);
    }

    @PostMapping(value="/add",produces = ApiConstants.STUDENT_V2)
    public ResponseEntity<GenericResponse<StudentResponse>> addStudentV2(@RequestBody StudentPayload studentPayload){
        return studentService.addStudent(studentPayload,ApiConstants.STUDENT_V2);
    }
}
