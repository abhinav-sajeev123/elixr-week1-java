package com.example.practice.payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditStudentPayload {

    @Size(min = 1,max = 30, message ="Name must be between 3 and 30 characters" )
    private String name;

    @Min(value = 1,message = "Age must be greater than 0")
    private Integer age;

    @Size(min = 3,max = 20,message = "Course name must be between 3 and 30 characters")
    private String course;
}
