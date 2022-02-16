package com.mydev.matvey;


import org.jsoup.Jsoup;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;


public class DownloadPage {

    private String html;

    public Path connectPage(String url, Path path) {
        try {
            html = Jsoup.connect(url).get().html();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return savePage(html, path);
    }

    public Path savePage(String page, Path path) {
        Path resultPath = Path.of(String.valueOf(path), "result.html");
        byte[] strToBytes = page.getBytes();
        try {
            Files.write(resultPath, strToBytes, CREATE, TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultPath;
    }

}
