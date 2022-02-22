package ru.mydev.matvey;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;
import static java.util.function.Function.identity;

class HtmlWordCounterUtil {

    private static final Logger log = Logger.getLogger(HtmlWordCounterUtil.class);

    private HtmlWordCounterUtil() {
    }

    /**
     * Gets the number of unique words from Html file
     *
     * @param path html page path
     */
    public static Map<String, Integer> calcFrequency(Path path) throws IOException {
        StringBuilder sb = new StringBuilder();
        Files.readAllLines(path)
                .forEach(sb::append);
        if (sb.length() != 0) {
            String title = String.valueOf(sb);
            Document doc = Jsoup.parse(title);
            String text = doc.body().text();
            log.info("Clear text received");
            return Stream.of(text.split("\\P{L}+"))
                    .collect(toMap(identity(), it -> 1, Integer::sum));
        } else {
            log.error("File is empty");
            throw new IOException("File is empty");
        }
    }

}
