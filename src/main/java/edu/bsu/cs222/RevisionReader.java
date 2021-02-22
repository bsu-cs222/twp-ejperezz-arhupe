package edu.bsu.cs222;
//import java.io.IOException;
import java.util.Scanner;

public class RevisionReader  {
    public static void main(String[] args) {
        System.out.println("Enter wikipedia name: \n");
        Scanner in = new Scanner(System.in);
        if (in.nextLine().length() < 1) {
            System.out.println("Must pass in wikipedia name");
        }
        String input = in.nextLine();
        RevisionReader reader = new RevisionReader();
        String results = reader.WikipediaData(input);
        System.out.println("The results you're trying to see are \n" + results);
        System.exit(0);
    }
    private String WikipediaData(String input)  {
        WikipediaData jsonData = new WikipediaData();
        return jsonData.WikipediaData(input);
    }



}
