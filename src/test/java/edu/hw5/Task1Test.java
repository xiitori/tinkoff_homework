package edu.hw5;

import edu.hw5.task1.TimeUtils;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    void test() {
        var result = TimeUtils.getTimeSession(List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        ));

        System.out.println(result);
    }
}
