package edu.hw6;

import edu.hw6.task3.AbstractFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static edu.hw6.task3.Filters.globMatches;
import static edu.hw6.task3.Filters.largerThan;
import static edu.hw6.task3.Filters.regexContains;

public class AbstractFilterTest {
    public static final AbstractFilter regularFile = Files::isRegularFile;
    public static final AbstractFilter readable = Files::isReadable;

    @Test
    void test() throws IOException {
        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable)
            .and(largerThan(100_000))
//            .and(magicNumber(0x89, 'P', 'N', 'G'))
            .and(globMatches("png"))
            .and(regexContains("[-]"));
    }

    @Test
    void another() {
        Path path = Path.of("src/main/java/edu/hw6/task4/test.txt");
        try {
            String str = Files.probeContentType(path);
            System.out.println(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
