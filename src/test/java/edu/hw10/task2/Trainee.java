package edu.hw10.task2;

import edu.hw10.task1.annotations.Min;
import edu.hw10.task1.annotations.NotNull;

public record Trainee(String name, String surname, int age, int studentId) implements Nameable, Student {
    public Trainee(@NotNull String name, String surname, int age, @Min(1) int studentId) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.studentId = studentId;
    }

    @Override
    public Integer getStudentId() {
        return studentId;
    }
}
