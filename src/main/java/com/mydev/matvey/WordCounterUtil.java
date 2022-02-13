package com.mydev.matvey;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toMap;
import static java.util.function.Function.identity;

public final class WordCounterUtil {

    private static final String pattern = "([^а-яА-Яa-zA-Z']+)'*\\1*";

    public WordCounterUtil() {
    }

    public static Map<String, Integer> calcFrequency(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path, UTF_8)) {
            return lines.flatMap(Pattern.compile(pattern)::splitAsStream)
                    .collect(toMap(identity(), it -> 1, Integer::sum));
        }
    }
}
