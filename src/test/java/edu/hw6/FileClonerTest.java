package edu.hw6;

import edu.hw6.task2.FileCloner;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    private static final Path PATH = Path.of("src/main/resources/hw6/task2/file.txt");
    @Test
    void copyTest() throws IOException {
        Path result = FileCloner.cloneFile(PATH);
        var pathContent = Files.readAllLines(PATH);
        var resultContent = Files.readAllLines(result);

        assertThat(result.getFileName().toString()).isEqualTo("file — копия.txt");
        assertThat(pathContent).isEqualTo(resultContent);

        Files.delete(result);
    }

    @Test
    void moreCopyTest() throws IOException {
        Path first = FileCloner.cloneFile(PATH);
        Path second = FileCloner.cloneFile(PATH);
        var pathContent = Files.readAllLines(PATH);
        var firstContent = Files.readAllLines(first);
        var secondContent = Files.readAllLines(second);

        assertThat(first.getFileName().toString()).isEqualTo("file — копия.txt");
        assertThat(pathContent).isEqualTo(firstContent);

        assertThat(second.getFileName().toString()).isEqualTo("file — копия(1).txt");
        assertThat(pathContent).isEqualTo(secondContent);

        Files.delete(first);
        Files.delete(second);
    }
}
