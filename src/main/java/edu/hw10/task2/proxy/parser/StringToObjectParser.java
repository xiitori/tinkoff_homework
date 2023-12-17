package edu.hw10.task2.proxy.parser;

public interface StringToObjectParser {

    Object parse(String value);

    static Object parseByType(String value, Class<?> type) {
        StringToObjectParser parser;
        if (type == String.class) {
            parser = new DefaultParser();
        } else if (type == Integer.class) {
            parser = new StringToIntParser();
        } else if (type == Long.class) {
            parser = new StringToLongParser();
        } else if (type == Double.class) {
            parser = new StringToDoubleParser();
        } else {
            parser = new DefaultParser();
        }

        return parser.parse(value);
    }
}
