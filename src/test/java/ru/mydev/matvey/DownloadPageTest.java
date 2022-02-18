package ru.mydev.matvey;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

class DownloadPageTest {

    DownloadPage downloadPage = new DownloadPage();

    @Test
    void ifUrlOrPathIsNull() {
        Assertions.assertThrows(NullPointerException.class,
                () -> downloadPage.connectPage(null, null), "Null parameters");
    }

    @Test
    void ifUrlIsEmpty() {
        Assertions.assertThrows(RuntimeException.class,
                () -> downloadPage.connectPage("", Path.of("src")), "Empty url");
    }
}
