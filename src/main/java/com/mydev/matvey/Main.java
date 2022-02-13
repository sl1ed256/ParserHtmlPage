package com.mydev.matvey;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("src", "main", "resources", "income.txt");
        Map<String, Integer> wordsMap = WordCounterUtil.calcFrequency(path);

        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
