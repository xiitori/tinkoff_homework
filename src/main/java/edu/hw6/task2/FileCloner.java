package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCloner {

    private FileCloner() {
    }

    public static Path cloneFile(Path path) {
        String fileName = path.getFileName().toString();
        String baseName;
        String extension;
        if (path.toString().contains(".")) {
            baseName = fileName.substring(0, fileName.lastIndexOf("."));
            extension = fileName.substring(fileName.lastIndexOf("."));
        } else {
            baseName = fileName;
            extension = "";
        }

        int copyNumber = 0;
        Path copyPath = Path.of(path.getParent().toString() + "/" + baseName + " — копия" + extension);
        while (Files.exists(copyPath)) {
            copyNumber++;
            copyPath =
                Path.of(path.getParent().toString() + "/" + baseName + " — копия(" + copyNumber + ")" + extension);
        }

        try {
            Files.copy(path, copyPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return copyPath;
    }
}
