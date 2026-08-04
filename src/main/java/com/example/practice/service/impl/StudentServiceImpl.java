package com.example.practice.service.impl;
import com.example.practice.exception.StudentNotFoundException;
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
        for (Student s : students) {
            if (s.getId() == studentPayload.getId()) {

                StudentResponse response=new StudentResponse();
                response.setMessage("Student with the id "+studentPayload.getId()+" already exist");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
            }
        }
        Student student = new Student();
        student.setId(studentPayload.getId());
        student.setName(studentPayload.getName());
        student.setAge(studentPayload.getAge());
        student.setCourse(studentPayload.getCourse());
        students.add(student);

        StudentResponse response = new StudentResponse();
        response.setAge(student.getAge());
        response.setName(student.getName());
        response.setCourse(student.getCourse());
        response.setMessage("Student added successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @Override
    public ResponseEntity<List<StudentResponse>> getStudents() {
        List<StudentResponse> responses = new ArrayList<>();
        if(!students.isEmpty()) {
            for (Student s : students) {
                StudentResponse studentResponse = new StudentResponse();
                studentResponse.setId(s.getId());
                studentResponse.setName(s.getName());
                studentResponse.setAge(s.getAge());
                studentResponse.setCourse(s.getCourse());
                responses.add(studentResponse);
            }
            return ResponseEntity.status(HttpStatus.OK).body(responses);
        }
       throw new StudentNotFoundException("No students exist in this list");
    }


    @Override
    public ResponseEntity<StudentResponse> editStudent(int id, EditStudentPayload editPayload) {
            for (Student student : students) {

                if (student.getId() == id) {

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
                    return ResponseEntity.status(HttpStatus.OK).body(response);
                }
            }
        StudentResponse response=new StudentResponse();
        response.setMessage("Student with id "+id+" doesn't exist");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
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
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @Override
    public ResponseEntity<StudentResponse> getStudentById(int id) {
        for(Student s:students){
            if(s.getId()==id){
                StudentResponse response=new StudentResponse();
                response.setName(s.getName());
                response.setAge(s.getAge());
                response.setCourse(s.getCourse());
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        }
      throw new StudentNotFoundException("Student with this id "+id+" doesn't exist");
    }
}


