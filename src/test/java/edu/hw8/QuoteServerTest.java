package edu.hw8;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import edu.hw8.task1.QuoteClient;
import edu.hw8.task1.QuoteMap;
import edu.hw8.task1.QuoteServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class QuoteServerTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    void startServerTest() throws IOException {
        QuoteServer server = new QuoteServer();
        server.startServer();
    }

    Callable<Void> task = () -> {
        QuoteClient client = new QuoteClient();

        LOGGER.info(client.doRequest("не"));
        return null;
    };

    @Test
    void clientRequestTest() throws IOException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        var tasks = Stream.generate(() -> task).limit(10).toList();

        try {
            var futures = service.invokeAll(tasks);
            for (var future : futures) {
                future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @Test

    void mapTest() {
        QuoteMap map = new QuoteMap();
        map.addQuote("Я люблю сосать члены");
        map.addQuote("Не переходи на личности там, где их нет");
        map.addQuote("Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами");
        map.addQuote("А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.");
        map.addQuote("Чем ниже интеллект, тем громче оскорбления");
    }

    @Test
    void test() {
        Pattern pattern = Pattern.compile("([а-яА-Я]+)");
        var matcher = pattern.matcher("я люблю тебя");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
