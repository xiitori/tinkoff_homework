package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuoteServer {

    private static final int MAX_CONNECTIONS = 5;
    private static final int PORT = 18080;

    private final QuoteMap map = new QuoteMap();

    {
        map.addQuote("Я люблю сосать члены");
        map.addQuote("Не переходи на личности там, где их нет");
        map.addQuote("Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами");
        map.addQuote("А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.");
        map.addQuote("Чем ниже интеллект, тем громче оскорбления");
    }

    public void startServer() throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        ExecutorService service = Executors.newFixedThreadPool(MAX_CONNECTIONS);

        while (true) {
            Socket connection = server.accept();
            System.out.println("Client is connected!");
            service.submit(() -> {
                try {
                    String request;
                    try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                        request = reader.readLine();
                    }

                    try (PrintWriter writer = new PrintWriter(connection.getOutputStream(), true)) {
                        String response = map.getRandomByWord(request);
                        writer.println(response);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });


        }
    }
}
