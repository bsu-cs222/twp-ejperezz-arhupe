package edu.bsu.cs222;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class RevisionParser {
    public Object parse(InputStream stream) throws IOException {
        JSONArray results = JsonPath.read(stream, "$..revisions");
        return results.get(0);
    }
    public String parseFirst(InputStream stream) throws IOException {
        JSONArray results = JsonPath.read(stream, "$..timestamp");
        return results.get(0).toString();
    }
}



