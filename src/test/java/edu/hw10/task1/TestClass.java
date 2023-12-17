package edu.hw10.task1;

public class TestClass {

    private final int number;

    private final String value;
    private TestClass(int number, String value) {
        this.number = number;
        this.value = value;
    }

    public static TestClass getTestClass(int number, String value) {
        return new TestClass(number, value);
    }
}
