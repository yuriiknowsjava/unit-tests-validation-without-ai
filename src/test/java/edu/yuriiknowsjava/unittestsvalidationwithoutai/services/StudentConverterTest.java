package edu.yuriiknowsjava.unittestsvalidationwithoutai.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.yuriiknowsjava.unittestsvalidationwithoutai.dtos.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class StudentConverterTest {
    private final StudentConverter studentConverter = new StudentConverter();

    @BeforeEach
    void preconditions() {
    }

    @DisplayName("Test convert high achievers")
    @Test
    void convertStudentsThatAreHighAchievers() {
        var expectedListSize = 4;
        List<Student> highAchievers = Stream.iterate(1, i -> i + 1)
                .limit(expectedListSize)
                .map(i -> {
                    var student = new Student();
                    student.setGrade(91 + (i % expectedListSize));
                    student.setAge(21 + i);
                    return student;
                })
                .collect(Collectors.toList());

        var result = studentConverter.convertStudents(highAchievers);
        Stream<Executable> assertions = result.stream()
                .map(student -> () -> assertTrue(
                        student.isHonorRoll(),
                        String.format("Student of age %s and with a grade %s should have honor roll", student.getAge(), student.getGrade())
                ));

        assertEquals(expectedListSize, result.size());
        assertAll(assertions);
    }

    @DisplayName("Test convert exceptional young high achievers")
    @Test
    void convertStudentsThatAreExceptionalYoungHighAchievers() {
        var expectedListSize = 5;
        List<Student> exceptionalYoungHighAchievers = Stream.iterate(1, i -> i + 1)
                .limit(expectedListSize)
                .map(i -> {
                    var student = new Student();
                    student.setGrade(91 + (i % expectedListSize));
                    student.setAge(21 - i);
                    return student;
                })
                .collect(Collectors.toList());

        var result = studentConverter.convertStudents(exceptionalYoungHighAchievers);
        Stream<Executable> assertions = result.stream()
                .map(student -> () -> assertTrue(
                        student.isExceptional(),
                        String.format("Student of age %s and with a grade %s should be exceptional", student.getAge(), student.getGrade())
                ));

        assertEquals(expectedListSize, result.size());
        assertAll(assertions);
    }

    @DisplayName("Test convert students that passed")
    @Test
    void convertStudentsThatPassed() {
        List<Student> studentsThatPassed = Stream.of(71, 75, 80, 81, 89, 90)
                .map(grade -> {
                    var student = new Student();
                    student.setGrade(grade);
                    return student;
                })
                .collect(Collectors.toList());

        var result = studentConverter.convertStudents(studentsThatPassed);
        Stream<Executable> assertions = result.stream()
                .map(student -> () -> assertTrue(
                        student.isPassed(),
                        String.format("Student with a grade %s should pass", student.getGrade())
                ));

        assertEquals(studentsThatPassed.size(), result.size());
        assertAll(assertions);
    }

    @DisplayName("Test convert students that failed")
    @Test
    void convertStudentsThatFailed() {
        List<Student> failedStudents = Stream.of(70, 69, 40)
                .map(grade -> {
                    var student = new Student();
                    student.setGrade(grade);
                    return student;
                })
                .collect(Collectors.toList());

        var result = studentConverter.convertStudents(failedStudents);
        Stream<Executable> assertions = result.stream()
                .map(student -> () -> assertFalse(
                        student.isPassed(),
                        String.format("Student with a grade %s should fail", student.getGrade())
                ));

        assertEquals(failedStudents.size(), result.size());
        assertAll(assertions);
    }

    @DisplayName("Test convert students with empty list")
    @Test
    void convertStudentsOfEmptyList() {
        var result = studentConverter.convertStudents(List.of());
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @SuppressWarnings("all")
    @DisplayName("Test convert students with null parameter")
    @Test
    void convertStudentsHandlesNull() {
        assertThrows(NullPointerException.class, () -> studentConverter.convertStudents(null));
    }
}
