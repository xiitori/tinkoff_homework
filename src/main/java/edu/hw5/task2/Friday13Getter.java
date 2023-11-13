package edu.hw5.task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.LinkedList;
import java.util.List;

public class Friday13Getter {
    private static final int THIRTEENTH = 13;

    private int year;

    public Friday13Getter(int year) {
        setYear(year);
    }

    public void setYear(int year) {
        if (year > 0) {
            this.year = year;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public List<LocalDate> getFridays13() {
        LocalDate currentDate = LocalDate.of(year, Month.JANUARY, THIRTEENTH);
        var list = new LinkedList<LocalDate>();

        while (currentDate.getYear() == year) {
            DayOfWeek month = currentDate.getDayOfWeek();
            if (month == DayOfWeek.FRIDAY) {
                list.add(currentDate);
            }
            currentDate = currentDate.plusMonths(1);
        }
        return list;
    }

    public static LocalDate getNextFriday13(LocalDate date) {
        LocalDate currentDate = date;

        do {
            currentDate = currentDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        } while (currentDate.getDayOfMonth() != THIRTEENTH);

        return currentDate;
    }
}
