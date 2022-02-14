package com.mydev.matvey;


import org.jsoup.Jsoup;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;


public class DownloadPage {

    private String html;

    public Path readPage(String url) {
        try {
            html = Jsoup.connect(url).get().html();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return savePage(html);
    }

    public Path savePage(String page) {
        Path resultPath = Path.of("src", "main", "resources", "result.html");
        byte[] strToBytes = page.getBytes();
        try {
            Files.write(resultPath, strToBytes, CREATE, TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultPath;
    }

}
