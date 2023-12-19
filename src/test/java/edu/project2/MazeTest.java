package edu.project2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MazeTest {

    private static final Maze testMaze = new Maze(8, 6);

    static {
        for (int i = 0; i < testMaze.getHeight() - 1; i++) {
            testMaze.getCell(i, 0).wallBottom = false;
        }
        testMaze.getCell(5, 1).wallLeft = false;
        testMaze.getCell(5, 2).wallLeft = false;
        testMaze.getCell(4, 2).wallBottom = false;
        testMaze.getCell(4, 2).wallLeft = false;
        testMaze.getCell(3, 1).wallBottom = false;
        for (int i = 2; i < testMaze.getWidth(); i++) {
            testMaze.getCell(3, i).wallLeft = false;
        }
        testMaze.getCell(3, 7).wallBottom = false;
        testMaze.getCell(4, 7).wallBottom = false;
        testMaze.getCell(5, 7).wallLeft = false;
        testMaze.getCell(4, 6).wallBottom = false;
        testMaze.getCell(4, 6).wallLeft = false;
        testMaze.getCell(3, 7).wallLeft = false;
        testMaze.getCell(4, 5).wallBottom = false;
        testMaze.getCell(5, 5).wallLeft = false;
        testMaze.getCell(5, 4).wallLeft = false;
        testMaze.getCell(4, 3).wallBottom = false;
        testMaze.getCell(4, 4).wallLeft = false;
        testMaze.getCell(2, 7).wallBottom = false;
        testMaze.getCell(1, 7).wallBottom = false;
        testMaze.getCell(0, 7).wallBottom = false;
        testMaze.getCell(0, 7).wallLeft = false;
        testMaze.getCell(0, 6).wallLeft = false;
        testMaze.getCell(0, 6).wallBottom = false;
        testMaze.getCell(1, 6).wallLeft = false;
        testMaze.getCell(1, 5).wallBottom = false;
        testMaze.getCell(1, 5).wallLeft = false;
        testMaze.getCell(2, 6).wallLeft = false;
        testMaze.getCell(0, 4).wallBottom = false;
        testMaze.getCell(0, 4).wallLeft = false;
        testMaze.getCell(0, 3).wallLeft = false;
        testMaze.getCell(0, 2).wallLeft = false;
        testMaze.getCell(0, 1).wallBottom = false;
        testMaze.getCell(1, 1).wallBottom = false;
        testMaze.getCell(2, 2).wallLeft = false;
        testMaze.getCell(1, 2).wallLeft = false;
        testMaze.getCell(2, 3).wallLeft = false;
        testMaze.getCell(2, 4).wallLeft = false;
    }

    @Test
    void solverFindSolutionTest() {
        Solver solver = new DFSSolver();

        solver.solve(testMaze, new Coordinate(0, 0), new Coordinate(2, 5));

        assertThat(testMaze.getPath().isEmpty()).isFalse();
    }

    @Test
    void impossibleSolutionTest() {
        Solver solver = new DFSSolver();

        solver.solve(testMaze, new Coordinate(0, 0), new Coordinate(1, 3));
        assertThat(testMaze.getPath().isEmpty()).isTrue();
    }

    @Test
    void incorrectParametersInGeneratorTest() {
        Generator generator = new RecursiveBackTrackerGenerator();
        assertThrows(IllegalArgumentException.class, () -> generator.generateMaze(-1, 8));
        assertThrows(IllegalArgumentException.class, () -> generator.generateMaze(4, 0));
    }

    @Test
    void generatedMazeTest() {
        Generator generator = new RecursiveBackTrackerGenerator();
        Maze maze = generator.generateMaze(15, 10);
        Solver solver = new DFSSolver();
        solver.solve(maze, new Coordinate(0,0), new Coordinate(9, 14));
        Renderer.render(maze);
        assertThat(maze.getPath().isEmpty()).isFalse();
    }
}
