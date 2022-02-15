package com.mydev.matvey;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите адрес веб-страницы");
        Scanner input = new Scanner(System.in);
        String url = input.nextLine();
        input.close();
        DownloadPage downloadPage = new DownloadPage();
        Map<String, Integer> wordsMap = WordCounterUtil.calcFrequency(downloadPage.readPage(url));
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }
}
