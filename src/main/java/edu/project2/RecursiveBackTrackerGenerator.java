package edu.project2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class RecursiveBackTrackerGenerator implements Generator {

    private static final Random RANDOM = new Random();

    public Maze generateMaze(int width, int height) {
        if (!(width > 0) || !(height > 0)) {
            throw new IllegalArgumentException();
        }

        Maze maze = new Maze(width, height);
        Cell current = maze.getCell(0, 0);
        current.isVisited = true;

        Stack<Cell> stack = new Stack<>();
        do {
            var unvisitedNeighbors = getUnvisitedNeighbors(current, maze);

            if (!unvisitedNeighbors.isEmpty()) {
                Cell choose = unvisitedNeighbors.get(RANDOM.nextInt(0, unvisitedNeighbors.size()));
                removeWall(current, choose);

                choose.isVisited = true;
                stack.push(choose);
                current = choose;
            } else {
                current = stack.pop();
            }
        } while (!stack.empty());

        maze.clearVisitHistory();
        return maze;
    }

    private List<Cell> getUnvisitedNeighbors(Cell cell, Maze maze) {
        int row = cell.getRow();
        int col = cell.getCol();
        int width = maze.getWidth();
        int height = maze.getHeight();

        List<Cell> unvisitedNeighbors = new LinkedList<>();

        if (row > 0 && !maze.getCell(row - 1, col).isVisited) {
            unvisitedNeighbors.add(maze.getCell(row - 1, col));
        }
        if (row + 1 < height && !maze.getCell(row + 1, col).isVisited) {
            unvisitedNeighbors.add(maze.getCell(row + 1, col));
        }
        if (col > 0 && !maze.getCell(row, col - 1).isVisited) {
            unvisitedNeighbors.add(maze.getCell(row, col - 1));
        }
        if (col + 1 < width && !maze.getCell(row, col + 1).isVisited) {
            unvisitedNeighbors.add(maze.getCell(row, col + 1));
        }

        return unvisitedNeighbors;
    }
}
