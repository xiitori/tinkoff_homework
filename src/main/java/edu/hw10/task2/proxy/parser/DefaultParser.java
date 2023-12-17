package edu.hw10.task2.proxy.parser;

public class DefaultParser implements StringToObjectParser {
    @Override
    public Object parse(String value) {
        return value;
    }
}
