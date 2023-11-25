package edu.hw6.task5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import static edu.hw6.task5.ResponseParseUtils.getTitleFromBody;
import static edu.hw6.task5.ResponseParseUtils.parseBodyToArray;

public class HackerNews {

    private static final int MAX_TIMEOUT = 10;

    public long[] hackerNewsTopStories() throws IOException, InterruptedException, URISyntaxException {
        var request = HttpRequest.newBuilder()
            .uri(new URI("https://hacker-news.firebaseio.com/v0/topstories.json"))
            .GET()
            .timeout(Duration.ofSeconds(MAX_TIMEOUT))
            .build();
        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return parseBodyToArray(response.body());
    }

    private static URI getURIById(long id) throws URISyntaxException {
        String uri = String.format("https://hacker-news.firebaseio.com/v0/item/%d.json", id);
        return new URI(uri);
    }

    public String news(long id) throws URISyntaxException, IOException, InterruptedException {
        var uri = getURIById(id);
        var request = HttpRequest.newBuilder()
            .uri(uri)
            .GET()
            .timeout(Duration.ofSeconds(MAX_TIMEOUT))
            .build();
        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return getTitleFromBody(response.body());
    }
}
