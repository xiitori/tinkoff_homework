package edu.project2;

import java.util.List;

public class Renderer {

    private static final String LEFT_WALL = "|";

    private static final String NO_LEFT_WALL = " ";

    private static final String BOTTOM_WALL = "---";

    private static final String NO_BOTTOM_WALL = "-  ";

    private static final String CELL = "  ";

    private static final String PATH = "◦ ";

    private static final String FINISH = "●●";

    private Renderer() {
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void render(Maze maze) {
        int width = maze.getWidth();
        int height = maze.getHeight();
        List<Coordinate> path = maze.getPath();

        for (int i = 0; i < height; i++) {
            if (i == 0) {
                System.out.println(BOTTOM_WALL.repeat(width));
            }
            StringBuilder walls = new StringBuilder();
            for (int j = 0; j < width; j++) {
                Cell cell = maze.getCell(i, j);
                if (cell.wallLeft) {
                    System.out.print(LEFT_WALL);
                } else {
                    System.out.print(NO_LEFT_WALL);
                }

                if (cell.wallBottom) {
                    walls.append(BOTTOM_WALL);
                } else {
                    walls.append(NO_BOTTOM_WALL);
                }

                if (path.contains(cell.getCoordinate())) {
                    if (path.get(0).equals(cell.getCoordinate())) {
                        System.out.print(FINISH);
                    } else {
                        System.out.print(PATH);
                    }
                } else {
                    System.out.print(CELL);
                }

                if (j == width - 1) {
                    System.out.print(LEFT_WALL);
                }
            }
            System.out.println();
            System.out.println(walls);
        }
    }
}
