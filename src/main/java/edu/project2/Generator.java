package edu.project2;

public interface Generator {

    Maze generateMaze(int width, int height);

    default void removeWall(Cell c1, Cell c2) {
        if (c1.getRow() == c2.getRow()) {
            if (c1.getCol() > c2.getCol()) {
                c1.wallLeft = false;
            } else {
                c2.wallLeft = false;
            }
        } else {
            if (c1.getRow() > c2.getRow()) {
                c2.wallBottom = false;
            } else {
                c1.wallBottom = false;
            }
        }
    }
}
