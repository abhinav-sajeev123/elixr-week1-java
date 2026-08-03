package com.example.practice.service.impl;

import com.example.practice.model.Student;
import com.example.practice.payload.StudentPayload;
import com.example.practice.response.StudentResponse;
import com.example.practice.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    List<Student>students=new ArrayList<>();

    @Override
    public ResponseEntity<StudentResponse> addStudent(StudentPayload studentPayload) {
        Student student=new Student();
        student.setId(studentPayload.getId());
        student.setName(studentPayload.getName());
        student.setAge(studentPayload.getAge());
        student.setCourse(studentPayload.getCourse());
        students.add(student);

        StudentResponse response=new StudentResponse();
        response.setAge(student.getAge());
        response.setName(student.getName());
        response.setCourse(student.getCourse());
        response.setMessage("Student added successfully");

        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.status(HttpStatus.FOUND).body(students);
    }
}
