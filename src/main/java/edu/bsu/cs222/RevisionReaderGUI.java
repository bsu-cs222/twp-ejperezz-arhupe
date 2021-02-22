package edu.bsu.cs222;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class RevisionReaderGUI {
    TextField input = new TextField();
    TextField response = new TextField();
        output.setEditable(false);
    Button wikiRevisionButton = new Button("Find the previous 30 revisions to the article");
    String articleTitle;

    {
        articleTitle = input.getText();
    }
    try{
        WikipediaData.checkTitle(articleTitle);
        WikipediaData connection = new WikipediaConnection();
        System.out.println(results);
    }
}
