package edu.project2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class DFSSolver implements Solver {
    @Override
    public void solve(Maze maze, Coordinate start, Coordinate end) {
        maze.clearVisitHistory();
        List<Coordinate> pathList = new LinkedList<>();
        Cell current = maze.getCell(start.row(), start.col());
        Stack<Cell> stack = new Stack<>();
        do {
            if (current.getRow() == end.row() && current.getCol() == end.col()) {
                stack.push(current);
                break;
            }

            var neighborsWithoutWalls = getNeighborsWithoutWalls(current, maze);

            if (!neighborsWithoutWalls.isEmpty()) {
                Cell choose = neighborsWithoutWalls.get(new Random().nextInt(0, neighborsWithoutWalls.size()));

                stack.push(current);
                current.isVisited = true;

                current = choose;
            } else {
                current.isVisited = true;
                current = stack.pop();
            }
        } while (!stack.empty());

        while (!stack.empty()) {
            Cell cell = stack.pop();
            pathList.add(cell.getCoordinate());
        }

        maze.setPath(pathList);
    }

    private List<Cell> getNeighborsWithoutWalls(Cell cell, Maze maze) {
        int row = cell.getRow();
        int col = cell.getCol();
        int width = maze.getWidth();
        int height = maze.getHeight();

        List<Cell> possibleNeighbors = new LinkedList<>();

        if (row > 0 && !maze.getCell(row - 1, col).wallBottom && !maze.getCell(row - 1, col).isVisited) {
            possibleNeighbors.add(maze.getCell(row - 1, col));
        }
        if (row + 1 < height && !cell.wallBottom && !maze.getCell(row + 1, col).isVisited) {
            possibleNeighbors.add(maze.getCell(row + 1, col));
        }
        if (col > 0 && !cell.wallLeft && !maze.getCell(row, col - 1).isVisited) {
            possibleNeighbors.add(maze.getCell(row, col - 1));
        }
        if (col + 1 < width && !maze.getCell(row, col + 1).wallLeft && !maze.getCell(row, col + 1).isVisited) {
            possibleNeighbors.add(maze.getCell(row, col + 1));
        }

        return possibleNeighbors;
    }
}
