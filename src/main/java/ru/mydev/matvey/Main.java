package ru.mydev.matvey;


import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;


class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        log.info("Program has started");

        System.out.println("Enter url");
        Scanner input = new Scanner(System.in);
        String url = input.nextLine();
        log.info("Url entered");

        System.out.println("Enter the path where to save the html page");
        Path path = Path.of(input.nextLine(), "result.html");
        log.info("File created");
        input.close();

        try {
            DownloadPage downloadPage = new DownloadPage();
            downloadPage.connectPage(url, path);
            log.info("connectPage completed");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error: ", e);
        }

        try {
            Map<String, Integer> wordsMap = HtmlWordCounterUtil.calcFrequency(path);
            System.out.println("Word frequency statistics:");
            for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
            log.info("Frequency received");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error: ", e);
        }
    }
}
