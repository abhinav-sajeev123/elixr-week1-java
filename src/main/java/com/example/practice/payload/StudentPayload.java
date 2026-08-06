package com.example.practice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentPayload {

    private Integer id;
    private String name;
    private Integer age;
    private String course;

}
