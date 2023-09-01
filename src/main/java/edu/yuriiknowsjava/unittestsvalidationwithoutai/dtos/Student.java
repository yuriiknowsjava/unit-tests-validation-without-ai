package edu.yuriiknowsjava.unittestsvalidationwithoutai.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private String name;
    private int age;
    private int grade;
    private boolean exceptional;
    private boolean honorRoll;
    private boolean passed;
}
