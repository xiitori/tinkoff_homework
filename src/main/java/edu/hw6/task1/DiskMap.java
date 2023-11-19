package edu.hw6.task1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {

    private static final Pattern ENTRY_REGEX = Pattern.compile("^(.+)=(.+)$");

    private int size = 0;

    private final Path path = Path.of("src/main/java/edu/hw6/task1/DiskMap.txt");

    public DiskMap() {
        try {
            Files.write(path, "".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DiskMap(Path source) throws FileNotFoundException {
        this();
        if (!Files.exists(source)) {
            throw new FileNotFoundException();
        }

        try {
            var list = Files.readAllLines(source);
            for (String rec : list) {
                Entry entry = new Entry(rec);
                String entryString = entry.getFileRecord();
                Files.write(path, entryString.getBytes(), StandardOpenOption.APPEND);
                size++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Path saveIntoFile() {
        Path savePath = Path.of("src/main/java/edu/hw6/task1/" + this + "save");
        try {
            Files.createFile(savePath);
            Files.copy(path, savePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return savePath;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            var list = Files.readAllLines(path);
            for (String rec : list) {
                Entry entry = new Entry(rec);
                if (entry.key.equals(key)) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        try {
            var list = Files.readAllLines(path);
            for (String rec : list) {
                Entry entry = new Entry(rec);
                if (entry.value.equals(value)) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public String get(Object key) {
        try {
            var list = Files.readAllLines(path);
            for (String rec : list) {
                Entry entry = new Entry(rec);
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        var keySet = keySet();
        if (keySet.contains(key)) {
            throw new IllegalArgumentException("key already exists!");
        }
        try {
            Entry entry = new Entry(key, value);
            String entryString = entry.getFileRecord();
            Files.write(path, entryString.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        size++;
        return value;
    }

    @Override
    public String remove(Object key) {
        String value = "";
        try {
            var list = Files.readAllLines(path);
            for (String rec : list) {
                Entry entry = new Entry(rec);
                if (entry.key != key) {
                    String entryString = entry.getFileRecord();
                    Files.write(path, entryString.getBytes(), StandardOpenOption.APPEND);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        size--;
        return value;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        try {
            for (var key : m.keySet()) {
                Entry entry = new Entry(key, m.get(key));
                String entryString = entry.getFileRecord();
                Files.write(path, entryString.getBytes(), StandardOpenOption.APPEND);
                size++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clear() {
        try {
            FileChannel.open(path).truncate(0).close();
            size = 0;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        try {
            return Files.lines(path).map(s -> new Entry(s).key).collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    @Override
    public Collection<String> values() {
        try {
            return Files.lines(path).map(s -> new Entry(s).value).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    @Override
    public Set<Map.Entry<String, String>> entrySet() {
        try {
            return Files.lines(path).map(Entry::new).collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Entry implements Map.Entry<String, String> {

        private final String key;
        private String value;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        Entry(String object) {
            Matcher matcher = ENTRY_REGEX.matcher(object);
            if (matcher.find()) {
                this.key = matcher.group(1);
                this.value = matcher.group(2);
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String setValue(String value) {
            this.value = value;
            return value;
        }

        public String getFileRecord() {
            return key + "=" + value + "\n";
        }
    }
}
