package com.mydev.matvey;


import org.jsoup.Jsoup;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;


public class DownloadPage {

    public void connectPage(String url, Path path) {

        if (url.equals("") || path == null) {
            throw new RuntimeException("Invalid input parameters");
        }

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        try {
            String html = Jsoup.connect(url).get().html();
            savePage(html, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savePage(String page, Path path) {
        try {
            byte[] strToBytes = page.getBytes();
            Files.write(path, strToBytes, CREATE, TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
