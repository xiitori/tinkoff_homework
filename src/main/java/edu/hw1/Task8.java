package edu.hw1;

public class Task8 {

    private static final int FIELD_SIZE = 8;

    private Task8() {

    }

    private static final int[][] POSSIBLE_MOVES = new int[][] {
        {-2, -1}, {-2, 1}, {2, -1}, {2, 1},
        {-1, -2}, {-1, 2}, {1, -2}, {1, 2}
    };

    public static boolean knightBoardCapture(int[][] field) {
        if (field == null) {
            throw new NullPointerException();
        }
        if (!(field.length == FIELD_SIZE && field[0].length == FIELD_SIZE)) {
            return false;
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != 1) {
                    continue;
                }
                for (int[] possibleMove : POSSIBLE_MOVES) {
                    int x = i + possibleMove[0];
                    int y = j + possibleMove[1];
                    if (checkValidCoordinates(x, y) && field[x][y] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean checkValidCoordinates(int x, int y) {
        return (x > 0 && x < FIELD_SIZE) && (y > 0 && y < FIELD_SIZE);
    }
}
