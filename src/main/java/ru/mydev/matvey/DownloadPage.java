package ru.mydev.matvey;


import org.apache.log4j.Logger;
import org.jsoup.Jsoup;


import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;


class DownloadPage {

    private static final Logger log = Logger.getLogger(DownloadPage.class);

    /**
     * Establishes connection with url and gets page html code
     *
     * @param url  Page url string
     * @param path Where to save the file
     */
    public void connectPage(String url, Path path) throws MalformedURLException {

        if (url == null || path == null) {
            log.error("Null url or path");
            throw new NullPointerException("Null parameters");
        }

        if (url.length() == 0) {
            log.error("Empty url");
            throw new MalformedURLException("Empty url");
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

    /**
     * Saves the resulting HTML text to file
     *
     * @param page String of html text
     * @param path Where to save the file
     */
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
