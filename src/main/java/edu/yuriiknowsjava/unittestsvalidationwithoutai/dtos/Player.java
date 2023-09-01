package edu.yuriiknowsjava.unittestsvalidationwithoutai.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Player {
    public String name;
    public int age;
    public int experience;
    public List<Integer> skills;
}
