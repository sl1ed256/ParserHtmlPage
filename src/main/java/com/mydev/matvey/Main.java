package com.mydev.matvey;


import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Enter url");
        Scanner input = new Scanner(System.in);
        String url = input.nextLine();
        System.out.println("Enter the path where to save the html page");
        Path path = Path.of(input.nextLine(), "result.html");
        input.close();

        try {
            DownloadPage downloadPage = new DownloadPage();
            downloadPage.connectPage(url, path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Map<String, Integer> wordsMap = WordCounterUtil.calcFrequency(path);
            System.out.println("Word frequency statistics:");
            for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
