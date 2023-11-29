package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class QuoteClient {

    private static final int PORT = 18080;

    public List<String> doRequest(String request) throws IOException {
        Socket client = new Socket(InetAddress.getByName("localhost"), PORT);

        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
        writer.println(request);
        writer.flush();

        var list = new LinkedList<String>();

        new BufferedReader(new InputStreamReader(client.getInputStream())).lines().forEach(list::add);

        client.close();

        return list;
    }

}
