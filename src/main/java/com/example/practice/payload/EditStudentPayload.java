package com.example.practice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditStudentPayload {
    private String name;
    private int age;
    private String course;
}
