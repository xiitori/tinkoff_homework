package edu.hw9.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Finder {
    private final Map<Path, Integer> map = new ConcurrentHashMap<>();

    public Map<Path, Integer> check(Path path) {
        RecursiveTask<Integer> task = new TreeChecker(path);
        ForkJoinPool pool = new ForkJoinPool();

        pool.invoke(task);

        pool.shutdown();
        pool.close();

        return map;
    }

    private class TreeChecker extends RecursiveTask<Integer> {

        private final Path root;

        public TreeChecker(Path root) {
            this.root = root;
        }

        @Override
        protected Integer compute() {
            int countFiles = 0;
            List<Path> paths = new LinkedList<>();
            try (var stream = Files.newDirectoryStream(root)) {
                stream.forEach(paths::add);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            List<TreeChecker> subTasks = new LinkedList<>();
            for (Path path : paths) {
                if (!Files.isDirectory(path)) {
                    countFiles++;
                    continue;
                }
                TreeChecker checker = new TreeChecker(path);
                checker.fork();
                subTasks.add(checker);
            }

            for (var task : subTasks) {
                int res = task.join();
                countFiles += res;
            }
            if (countFiles > 1000) {
                map.put(this.root, countFiles);
            }

            return countFiles;
        }
    }
}
