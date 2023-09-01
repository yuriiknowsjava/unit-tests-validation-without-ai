package edu.yuriiknowsjava.unittestsvalidationwithoutai.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Player {
    private String name;
    private int age;
    private int experience;
    private List<Integer> skills;
}
