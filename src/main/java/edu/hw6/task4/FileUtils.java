package edu.hw6.task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public class FileUtils {
    private FileUtils() {
    }

    public static void writeStringIntoFile() {
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(
            new CheckedOutputStream(
                Files.newOutputStream(Path.of("src/main/java/edu/hw6/task4/test.txt")),
            new Adler32()))))) {
            writer.write("Programming is learned by writing programs. ― Brian Kernighan");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
