package edu.hw8.task1;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class QuoteMap {

    private final HashMap<String, List<String>> wordsMap = new HashMap<>();

    private static final Pattern WORD_REGEX = Pattern.compile("([а-яА-Я]+)");

    public void addQuote(String quote) {
        var words = new LinkedList<String>();

        var matcher = WORD_REGEX.matcher(quote);
        while (matcher.find()) {
            String word = matcher.group(1);
            word = word.toLowerCase();
            words.add(word);
        }

        for (String word : words) {
            if (wordsMap.containsKey(word)) {
                var quotesList = wordsMap.get(word);
                if (!quotesList.contains(quote)) {
                    quotesList.add(quote);
                }
            } else {
                var newList = new LinkedList<String>();
                newList.add(quote);
                wordsMap.put(word, newList);
            }
        }
    }

    public String getRandomByWord(String word) {
        SecureRandom random = new SecureRandom();
        var list = wordsMap.get(word);

        return list.get(random.nextInt(list.size()));
    }
}
