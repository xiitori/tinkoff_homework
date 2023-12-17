package edu.hw10.task2.proxy.parser;

public class StringToLongParser implements StringToObjectParser {
    @Override
    public Object parse(String value) {
        return Long.parseLong(value);
    }
}
