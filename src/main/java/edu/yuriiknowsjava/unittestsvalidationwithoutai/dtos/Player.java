package edu.yuriiknowsjava.unittestsvalidationwithoutai.dtos;

import java.util.List;

import lombok.Data;

@Data
public class Player {
    public String name;
    public int age;
    public int experience;
    public List<Integer> skills;
}
