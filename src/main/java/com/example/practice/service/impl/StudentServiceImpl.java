package com.example.practice.service.impl;

import com.example.practice.model.Student;
import com.example.practice.payload.EditStudentPayload;
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
    public ResponseEntity<List<StudentResponse>> getStudents() {
        List<StudentResponse> responses = new ArrayList<>();

            for (Student s : students) {
                StudentResponse studentResponse = new StudentResponse();
                studentResponse.setId(s.getId());
                studentResponse.setName(s.getName());
                studentResponse.setAge(s.getAge());
                studentResponse.setCourse(s.getCourse());
                responses.add(studentResponse);
            }
            return ResponseEntity.status(HttpStatus.FOUND).body(responses);
    }


    @Override
    public ResponseEntity<StudentResponse> editStudent(int id, EditStudentPayload editPayload) {


            for (Student student : students) {
                if (student.getId() == id) {
                    student.setName(editPayload.getName());
                    student.setAge(editPayload.getAge());
                    student.setCourse(editPayload.getCourse());

                    StudentResponse response = new StudentResponse();
                    response.setName(student.getName());
                    response.setAge(student.getAge());
                    response.setCourse(student.getCourse());
                    response.setMessage("updated successfully");
                    return ResponseEntity.status(HttpStatus.CREATED).body(response);

                }
            }

        StudentResponse response=new StudentResponse();
        response.setMessage("Student not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @Override
    public ResponseEntity<StudentResponse> deleteStudent(int id) {
        for(Student s:students){
            if(s.getId()==id){
                students.remove(s);
                StudentResponse response=new StudentResponse();
                response.setMessage("Deleted successfully");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        }
        StudentResponse response=new StudentResponse();
        response.setMessage("Student with "+id+" not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }
}


