package edu.hw10.task2.proxy.parser;

public class StringToCharacterParser implements StringToObjectParser {
    @Override
    public Object parse(String value) {
        return value.toCharArray()[0];
    }
}
