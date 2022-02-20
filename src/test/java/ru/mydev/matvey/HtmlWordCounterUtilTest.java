package ru.mydev.matvey;

import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class HtmlWordCounterUtilTest {

    @Test
    void throwExceptionIfFileIsEmpty() {
        Path pathEmptyFile = Path.of("src", "test", "resources", "EmptyFile.html");
        assertThrows(IOException.class, () -> HtmlWordCounterUtil.calcFrequency(pathEmptyFile), "File is empty");
    }

    @Test
    void simpleHtmlFile() throws IOException {
        Path pathSimpleFile = Path.of("src", "test", "resources", "SimpleHtmlPage.html");
        var mapWords = HtmlWordCounterUtil.calcFrequency(pathSimpleFile);
        Map<String, Integer> resultMap = Map.of("This", 5,
                "is", 5,
                "a", 5,
                "new", 3,
                "Header", 2,
                "Medium", 1,
                "paragraph", 2);
        assertEquals(mapWords, resultMap);
    }
}
