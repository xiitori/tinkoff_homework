package edu.project2;

public class Cell {

    public boolean wallLeft = true;

    public boolean wallBottom = true;

    public boolean isVisited = false;

    private final Coordinate coordinate;

    public Cell(int row, int col) {
        coordinate = new Coordinate(row, col);
    }

    public int getRow() {
        return coordinate.row();
    }

    public int getCol() {
        return coordinate.col();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
