package com.example.practice.payload;

import com.example.practice.validation.V1Validation;
import com.example.practice.validation.V2Validation;
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
public class StudentPayload {

    @NotNull(groups = {V1Validation.class, V2Validation.class}, message = "id is required")
    @Min(groups = {V1Validation.class, V2Validation.class}, value = 1,message = "Id should be greater than 0")
    private Integer id;

    @NotBlank(groups = {V1Validation.class, V2Validation.class}, message = "Name cannot be empty")
    @Size(groups = {V1Validation.class, V2Validation.class}, min=3,max = 30,message = "Name must be between 3 and 30 characters")
    private String name;

    @NotNull(groups = {V1Validation.class, V2Validation.class},message = "Age is required")
    @Min(groups = {V1Validation.class, V2Validation.class},value = 1,message = "Age should be greater than 0")
    private Integer age;

    @NotBlank(groups = V1Validation.class,message = "Course cannot be empty")
    private String course;
}
