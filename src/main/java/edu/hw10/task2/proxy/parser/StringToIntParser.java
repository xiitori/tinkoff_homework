package edu.hw10.task2.proxy.parser;

public class StringToIntParser implements StringToObjectParser {
    @Override
    public Object parse(String value) {
        return Integer.parseInt(value);
    }
}
