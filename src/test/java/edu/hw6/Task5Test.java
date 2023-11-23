package edu.hw6;

import edu.hw6.task5.HackerNews;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;

public class Task5Test {
    @Test
    void test() throws URISyntaxException, IOException, InterruptedException {
        System.out.println(HackerNews.news(38386547));
    }
}
