package edu.hw6;

import edu.hw6.task2.FileCloner;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;

public class FileClonerTest {
    @Test
    void test() {
        FileCloner.cloneFile(Path.of("src/main/java/edu/hw6/task1/DiskMap.txt"));
    }
}
