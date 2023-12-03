package edu.hw8.task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuoteClient {

    private static final int PORT = 5453;

    private static final int BUFFER_SIZE = 2048;

    private static final Logger LOGGER = LogManager.getLogger();

    private final SocketChannel connection;

    private QuoteClient() throws IOException {
        LOGGER.info("Getting connection with server...");
        connection = SocketChannel.open(new InetSocketAddress(PORT));
        LOGGER.info("Connection is made!");
    }

    public static QuoteClient start() throws IOException {
        return new QuoteClient();
    }

    public String doRequest(String request) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(request.getBytes());
        LOGGER.info("Sending request to the server...");
        connection.write(buffer);
        buffer = ByteBuffer.allocate(BUFFER_SIZE);
        connection.read(buffer);
        LOGGER.info("Response is received!");
        return new String(buffer.array()).trim();
    }

}
