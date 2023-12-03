package edu.hw8.task1;

import edu.hw8.task1.QuoteClient;
import edu.hw8.task1.QuoteServer;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class QuoteServerTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    void startServerTest() throws IOException, ExecutionException, InterruptedException {
        QuoteServer server = new QuoteServer();
        server.startServer();
    }

    @Test
    void clientRequestTest() throws InterruptedException {
        Callable<Void> task = () -> {
            QuoteClient client = QuoteClient.start();
            LOGGER.info(client.doRequest("оскорбления"));
            return null;
        };

        var tasks = Stream.generate(() -> task).limit(10).toList();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.invokeAll(tasks);
    }

    @Test
    void test() throws IOException {
        QuoteClient client = QuoteClient.start();
        client.doRequest("stop");
    }
}
