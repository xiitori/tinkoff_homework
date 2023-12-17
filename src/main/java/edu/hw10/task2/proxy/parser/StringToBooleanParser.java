package edu.hw10.task2.proxy.parser;

public class StringToBooleanParser implements StringToObjectParser {
    @Override
    public Object parse(String value) {
        return Boolean.parseBoolean(value);
    }
}
