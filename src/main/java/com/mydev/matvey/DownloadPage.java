package com.mydev.matvey;


import org.apache.log4j.Logger;
import org.jsoup.Jsoup;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;


public class DownloadPage {

    // Инициализация логера
    private static final Logger log = Logger.getLogger(DownloadPage.class);

    public void connectPage(String url, Path path) {

        if (url.equals("") || path == null) {
            log.error("Empty url or path");
            throw new RuntimeException("Invalid input parameters");
        }

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
            log.info("Added http:// to url");
        }

        try {
            String html = Jsoup.connect(url).get().html();
            log.info("Successful connection");
            savePage(html, path);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Can't connect to url!", e);
        }
    }

    public void savePage(String page, Path path) {
        try {
            byte[] strToBytes = page.getBytes();
            Files.write(path, strToBytes, CREATE, TRUNCATE_EXISTING);
            log.info("Successful file save");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Can't save file!", e);
        }
    }
}
