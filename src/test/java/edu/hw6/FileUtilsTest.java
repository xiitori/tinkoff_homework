package edu.hw6;

import edu.hw6.task4.FileUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    void writeStringTest() throws IOException {
        Path path = Path.of("src/main/resources/hw6/task4/test.txt");
        Files.writeString(path, "");

        FileUtils.writeStringIntoFile(path);
        var list = Files.readAllLines(path);

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0)).isEqualTo("Programming is learned by writing programs. ― Brian Kernighan");
    }
}
