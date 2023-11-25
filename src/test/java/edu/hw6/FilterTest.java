package edu.hw6;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.hw6.task3.Filters.IS_DIRECTORY;
import static edu.hw6.task3.Filters.IS_READABLE;
import static edu.hw6.task3.Filters.IS_REGULAR_FILE;
import static edu.hw6.task3.Filters.IS_WRITABLE;
import static edu.hw6.task3.Filters.globMatches;
import static edu.hw6.task3.Filters.largerThan;
import static edu.hw6.task3.Filters.regexContains;
import static org.assertj.core.api.Assertions.assertThat;

public class FilterTest {

    private static final Path PATH = Path.of("src/main/resources/hw6/task3");

    private static final Path PDF = Path.of("src/main/resources/hw6/task3/lection.pdf");

    private static final Path EXAMPLE = Path.of("src/main/resources/hw6/task3/example.txt");

    private static final Path DIRECTORY = Path.of("src/main/resources/hw6/task3/test");

    private static final Path MATCHES = Path.of("src/main/resources/hw6/task3/matches31@!4.txt");


    @Test
    void largerThanTest() throws IOException {
        DirectoryStream.Filter<Path> filter = largerThan(10);
        List<Path> answer = new ArrayList<>(List.of(EXAMPLE, PDF));

        List<Path> entries = new ArrayList<>();
        Files.newDirectoryStream(PATH, filter).forEach(entries::add);

        assertThat(entries).isEqualTo(answer);
    }

    @Test
    void globMatchesTest() throws IOException {
        DirectoryStream.Filter<Path> filter = globMatches("txt");
        List<Path> answer = new ArrayList<>();
        answer.add(EXAMPLE);
        answer.add(MATCHES);

        List<Path> entries = new ArrayList<>();
        Files.newDirectoryStream(PATH, filter).forEach(entries::add);

        assertThat(entries).isEqualTo(answer);
    }

    @Test
    void regexContainsTest() throws IOException {
        DirectoryStream.Filter<Path> filter = regexContains("(\\d{2}@!\\d)");
        List<Path> answer = new ArrayList<>(List.of(MATCHES));

        List<Path> entries = new ArrayList<>();
        Files.newDirectoryStream(PATH, filter).forEach(entries::add);

        assertThat(entries).isEqualTo(answer);
    }

    @Test
    void isDirectoryTest() throws IOException {
        DirectoryStream.Filter<Path> filter = IS_DIRECTORY;
        List<Path> answer = new ArrayList<>(List.of(DIRECTORY));

        List<Path> entries = new ArrayList<>();
        Files.newDirectoryStream(PATH, filter).forEach(entries::add);

        assertThat(entries).isEqualTo(answer);
    }

    @Test
    void andTest() throws IOException {
        DirectoryStream.Filter<Path> filter = IS_READABLE
            .and(IS_WRITABLE)
            .and(IS_REGULAR_FILE)
            .and(globMatches("txt"))
            .and(regexContains("match"));
        List<Path> answer = new ArrayList<>(List.of(MATCHES));

        List<Path> entries = new ArrayList<>();
        Files.newDirectoryStream(PATH, filter).forEach(entries::add);

        assertThat(entries).isEqualTo(answer);
    }
}
