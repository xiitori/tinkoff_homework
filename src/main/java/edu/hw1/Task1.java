package edu.hw1;

public class Task1 {

    private Task1() {

    }

    private static final int SECONDS_IN_MINUTE = 60;

    static int minutesToSeconds(String time) {
        String[] values = time.split(":");
        int minutes;
        int seconds;

        try {
            minutes = Integer.parseInt(values[0]);
            seconds = Integer.parseInt(values[1]);
        } catch (NumberFormatException e) {
            return -1;
        }

        if (seconds >= SECONDS_IN_MINUTE || seconds < 0 || minutes < 0) {
            return -1;
        }

        return minutes * SECONDS_IN_MINUTE + seconds;
    }
}
