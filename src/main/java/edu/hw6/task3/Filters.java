package edu.hw6.task3;

import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filters {

    public static final AbstractFilter REGULAR_FILE = Files::isRegularFile;

    public static final AbstractFilter READABLE = Files::isReadable;

    public static final AbstractFilter WRITEABLE = Files::isWritable;

    public static final AbstractFilter IS_DIRECTORY = Files::isDirectory;

    private Filters() {
    }

    public static AbstractFilter largerThan(int size) {
        return e -> Files.size(e) > size;
    }

    public static AbstractFilter globMatches(String glob) {
        return e -> e.getFileName().toString().matches("([\\w\\s]+\\." + glob + ")");
    }

    public static AbstractFilter regexContains(String regex) {
        return e -> {
            String fileName = e.getFileName().toString();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(fileName);
            return matcher.find();
        };
    }
}
