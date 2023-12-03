package edu.hw8.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuoteServer {

    private static final int MAX_CONNECTIONS = 5;
    private static final int PORT = 5453;
    private static final Logger LOGGER = LogManager.getLogger();

    private final QuoteMap map = new QuoteMap();

    {
        map.addQuote("Не переходи на личности там, где их нет");
        map.addQuote("Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами");
        map.addQuote(
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.");
        map.addQuote("Чем ниже интеллект, тем громче оскорбления");
    }

    public void startServer() throws IOException {
        LOGGER.info("Starting server...");
        try (ServerSocketChannel serverSocket = ServerSocketChannel.open();
             ExecutorService service = Executors.newFixedThreadPool(MAX_CONNECTIONS)) {
            serverSocket.bind(new InetSocketAddress(PORT));
            while (true) {
                LOGGER.info("Waiting for connection...");
                SocketChannel channel = serverSocket.accept();
                LOGGER.info("Connection with client is made!");
                service.submit(() -> {
                    try {
                        response(channel);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
    }

    private void response(SocketChannel client) throws IOException {
        LOGGER.info("Getting request from the client...");
        ByteBuffer buffer = ByteBuffer.allocate(2048);
        client.read(buffer);
        String request = new String(buffer.array()).trim();
        LOGGER.info("Request is received : " + request);
        String response = map.getRandomByWord(request);
        LOGGER.info("Sending response...");
        buffer = ByteBuffer.wrap(response.getBytes());
        client.write(buffer);
    }
}
