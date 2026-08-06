package com.example.practice.validation;
import com.example.practice.exception.ValidationException;
import com.example.practice.header_constants.ApiConstants;
import com.example.practice.payload.EditStudentPayload;
import com.example.practice.payload.StudentPayload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class StudentValidator {

        public void validate(StudentPayload payload,String version) {

            List<String> errors = new ArrayList<>();

            if (payload.getId() == null) {
                errors.add("Id is required");
            } else if (payload.getId() <= 0) {
                errors.add("Id should be greater than 0");
            }

            if (payload.getName() == null ||
                    payload.getName().isBlank()) {

                errors.add("Name cannot be empty");
            }
            else if (payload.getName().length() < 3 ||
                    payload.getName().length() > 30) {

                errors.add("Name must be between 3 and 30 characters");
            }

            if (payload.getAge() == null) {
                errors.add("Age is required");
            }
            else if (payload.getAge() <= 0) {
                errors.add("Age should be greater than 0");
            }

            if(version.equals(ApiConstants.STUDENT_V1)) {

                if (payload.getCourse() == null ||
                        payload.getCourse().isBlank()) {

                    errors.add("Course cannot be empty");
                }
            }

            if(version.equals(ApiConstants.STUDENT_V2)) {

                if (payload.getCourse() != null) {

                    errors.add("Course cannot be added");
                }
            }

            if (!errors.isEmpty()) {
                throw new ValidationException(errors);
            }
        }

        public void editValidate(Integer id,EditStudentPayload payload){
            List<String>errors=new ArrayList<>();

            if(id==null){
                errors.add("Id cannot be empty");
            } else if (id<=0) {
                errors.add("Id must be greater than 0");

            }

            if(payload.getName()!=null && payload.getName().length()<3||payload.getName().length()>30)
            {
                errors.add("Name must be between 3 and 30 characters");
            }

            if(payload.getAge()!=null && payload.getAge()<=0)
            {
                errors.add("Age must be greater than 0");
            }

            if(payload.getCourse()!=null && payload.getCourse().length()<3||payload.getCourse().length()>20)
            {
                errors.add("Course must be between 3 and 20 characters");
            }

            if(!errors.isEmpty()){
                throw new ValidationException(errors);
            }
        }
}

