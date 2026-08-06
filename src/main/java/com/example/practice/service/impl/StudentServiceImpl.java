package com.example.practice.service.impl;
import com.example.practice.exception.StudentNotFoundException;
import com.example.practice.model.Student;
import com.example.practice.payload.EditStudentPayload;
import com.example.practice.payload.StudentPayload;
import com.example.practice.response.GenericResponse;
import com.example.practice.response.Status;
import com.example.practice.response.StudentResponse;
import com.example.practice.service.StudentService;
import com.example.practice.validation.StudentValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentValidator studentValidator;

    List<Student>students=new ArrayList<>();

    @Override
    public ResponseEntity<GenericResponse<StudentResponse>> addStudent(StudentPayload studentPayload, String version) {
        studentValidator.validate(studentPayload,version);

        for (Student s : students) {
            if (s.getId().equals(studentPayload.getId())) {

                StudentResponse response=new StudentResponse();
                response.setMessage("Student with the id "+studentPayload.getId()+" already exist");

                GenericResponse<StudentResponse> genericResponse=new GenericResponse<>(
                        Status.FAILURE,
                        null,
                        null,
                        response,
                        LocalDateTime.now()
                );
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(genericResponse);
            }
        }
        Student student = new Student(studentPayload.getId(),studentPayload.getName(),
                studentPayload.getAge(),studentPayload.getCourse());
        students.add(student);

        StudentResponse response = new StudentResponse();
        response.setAge(student.getAge());
        response.setName(student.getName());
        response.setCourse(student.getCourse());

        GenericResponse<StudentResponse>genericResponse=new GenericResponse<>(
                Status.SUCCESS,
                null,
                null,
                response,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }


    @Override
    public ResponseEntity<GenericResponse<List<StudentResponse>>>getStudents() {
        List<StudentResponse> responses = new ArrayList<>();
        if (!students.isEmpty()) {
            for (Student s : students) {
                StudentResponse studentResponse = new StudentResponse();
                studentResponse.setId(s.getId());
                studentResponse.setName(s.getName());
                studentResponse.setAge(s.getAge());
                studentResponse.setCourse(s.getCourse());
                responses.add(studentResponse);
            }
            GenericResponse<List<StudentResponse>> genericResponse = new GenericResponse<>(
                    Status.SUCCESS,
                    null,
                    null,
                    responses,
                    LocalDateTime.now()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
        }
        throw new StudentNotFoundException("Students not exist in this list");
    }


    @Override
    public ResponseEntity<GenericResponse<StudentResponse>> editStudent(Integer id, EditStudentPayload editPayload) {
        studentValidator.editValidate(id,editPayload);
            for (Student student : students) {

                if (student.getId().equals(id)) {

                  if(editPayload.getName()!=null){
                      student.setName(editPayload.getName());
                  }
                  if(editPayload.getAge()!=null){
                      student.setAge(editPayload.getAge());
                  }

                  if(editPayload.getCourse()!=null){
                      student.setCourse(editPayload.getCourse());
                  }

                    StudentResponse response = new StudentResponse();
                    response.setName(student.getName());
                    response.setAge(student.getAge());
                    response.setCourse(student.getCourse());
                    response.setMessage("updated successfully");

                    GenericResponse<StudentResponse>genericResponse=new GenericResponse<>(
                            Status.SUCCESS,
                            null,
                            null,
                            response,
                            LocalDateTime.now()
                    );
                    return ResponseEntity.status(HttpStatus.OK).body(genericResponse);
                }
            }
       throw new StudentNotFoundException("Student with this id "+id+" doesn't exist");
    }

    @Override
    public ResponseEntity<GenericResponse<StudentResponse>> deleteStudent(Integer id) {
        for(Student s:students){
            if(s.getId().equals(id)){
                students.remove(s);
                StudentResponse response=new StudentResponse();
                response.setMessage("Deleted successfully");

                GenericResponse<StudentResponse>genericResponse=new GenericResponse<>(
                        Status.SUCCESS,
                        null,
                        null,
                        response,
                        LocalDateTime.now()
                );
                return ResponseEntity.status(HttpStatus.OK).body(genericResponse);
            }
        }
        throw new StudentNotFoundException("Student with this id "+id+" not found");
    }

    @Override
    public ResponseEntity<GenericResponse<StudentResponse>> getStudentById(Integer id) {
        for(Student s:students){
            if(s.getId().equals(id)){
                StudentResponse response=new StudentResponse();
                response.setName(s.getName());
                response.setAge(s.getAge());
                response.setCourse(s.getCourse());
                GenericResponse<StudentResponse>genericResponse=new GenericResponse<>(
                        Status.SUCCESS,
                        null,
                        null,
                        response,
                        LocalDateTime.now()
                );
                return ResponseEntity.status(HttpStatus.OK).body(genericResponse);
            }
        }
       throw new StudentNotFoundException("Student with this id "+id+" doesn't exist");

    }
}


