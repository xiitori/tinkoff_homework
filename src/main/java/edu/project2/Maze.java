package edu.project2;

import java.util.LinkedList;
import java.util.List;

public class Maze {

    private final int width;

    private final int height;

    private final Cell[][] maze;

    private List<Coordinate> path = new LinkedList<>();

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        maze = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell getCell(int row, int col) {
        return maze[row][col];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Coordinate> getPath() {
        return path;
    }

    public void setPath(List<Coordinate> path) {
        this.path = path;
    }

    public void clearVisitHistory() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j].isVisited = false;
            }
        }
    }
}
