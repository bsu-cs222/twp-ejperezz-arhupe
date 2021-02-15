package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParserTest {
    @Test
    public void testParse(){
        WikipediaRevisionParser parser = new WikipediaRevisionParser();

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("wikiTestData");
        String results = null;
        try {
            results = parser.parseFirst(inputStream);
            String testDate = results;
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("2021-02-08T18:12:21Z", results);
    }
}
