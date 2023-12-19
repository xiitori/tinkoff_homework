package edu.hw8.task2;

import edu.hw8.task1.QuoteClient;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class FixedThreadPoolTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    void poolTest() throws InterruptedException {
        FixedThreadPool pool = FixedThreadPool.create(3);
        pool.start();
        pool.execute(() -> {
            try {
                QuoteClient client = QuoteClient.start();
                LOGGER.info(client.doRequest("оскорбления"));
                Thread.sleep(5000);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        for (int i = 0; i < 2; i++) {
            pool.execute(() -> {
                try {
                    QuoteClient client = QuoteClient.start();
                    LOGGER.info(client.doRequest("оскорбления"));
                    Thread.sleep(7000);
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        pool.execute(() -> {
            try {
                QuoteClient client = QuoteClient.start();
                LOGGER.info(client.doRequest("оскорбления"));
                Thread.sleep(5000);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.sleep(15000);
    }
}
