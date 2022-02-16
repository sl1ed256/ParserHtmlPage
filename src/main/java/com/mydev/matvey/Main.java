package com.mydev.matvey;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter url");
        Scanner input = new Scanner(System.in);
        String url = input.nextLine();
        System.out.println("Enter the path where to save the html page");
        Path path = Path.of(input.nextLine());
        input.close();
        DownloadPage downloadPage = new DownloadPage();
        Map<String, Integer> wordsMap = WordCounterUtil.calcFrequency(downloadPage.connectPage(url, path));
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }
}
