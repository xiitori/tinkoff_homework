package edu.hw10.task2.proxy.parser;

public class StringToDoubleParser implements StringToObjectParser {
    @Override
    public Object parse(String value) {
        return Double.parseDouble(value);
    }
}
