package edu.hw10.task2;

import edu.hw10.task2.annotation.Cache;

public interface Student {
    @Cache()
    Integer getStudentId();
}
