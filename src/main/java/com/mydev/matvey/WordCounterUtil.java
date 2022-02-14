package com.mydev.matvey;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Map;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toMap;
import static java.util.function.Function.identity;

public final class WordCounterUtil {

    private static final String pattern = "[^a-яА-Яa-zA-Z]+";

    public WordCounterUtil() {
    }

    public static Map<String, Integer> calcFrequency(Path path) throws IOException {
        return Files.readAllLines(path).stream()
                .map(WordCounterUtil::removeHtmlCode)
                .flatMap(Pattern.compile(pattern)::splitAsStream)
                .collect(toMap(identity(), it -> 1, Integer::sum));
    }

    public static String removeHtmlCode(String str) {
        Document doc = Jsoup.parse(str);
        String text = doc.body().text();
        text = text.replaceAll("«", "");
        text = text.replaceAll("»", "");
        text = text.replaceAll("©", "");
        return text;
    }
}
