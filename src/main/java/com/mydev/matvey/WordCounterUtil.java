package com.mydev.matvey;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;
import static java.util.function.Function.identity;

public final class WordCounterUtil {

    public WordCounterUtil() {
    }

    public static Map<String, Integer> calcFrequency(Path path) throws IOException {
        StringBuilder sb = new StringBuilder();
        Files.readAllLines(path)
                .forEach(sb::append);
        String title = String.valueOf(sb);
        Document doc = Jsoup.parse(title);
        String text = doc.body().text();
        return Stream.of(text.split("\\P{L}+"))
                .collect(toMap(identity(), it -> 1, Integer::sum));
    }


}
