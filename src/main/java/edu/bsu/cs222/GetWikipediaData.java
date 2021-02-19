package edu.bsu.cs222;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

class GetWikipediaData {
    public String getWikipediaData(String input) {
        try {
            URL urlWiki =  new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Muncie,_Indiana&rvprop=timestamp|user&rvlimit=30&redirects");
            if(input.length() > 1)
            {
                urlWiki = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="+input+"&rvprop=timestamp|user&rvlimit=30&redirects");
            }
            URLConnection connection = urlWiki.openConnection();
            connection.setRequestProperty("User-Agent",
                    "Revision Tracker/0.1 (http://www.cs.bsu.edu/~pvg/courses/cs222Sp21; arhupe@bsu.edu)");
            InputStream inputStream = connection.getInputStream();
            // Object results = JsonPath.read(inputStream, "$..revisions");
            // String resultsString = results.toString();
            //TODO: figure out how to parse results and not have multiple calls
            //JSONObject jsonObject = new JSONObject(resultsString);
            //JSONArray arr = jsonObject.getJSONArray("user");
            JSONArray resultsTimeStamp = JsonPath.read(inputStream, "$..timestamp");
            String[] timeStamps = new String[resultsTimeStamp.size()];
            //if(resultsTimeStamp != null) {
            for(int i = 0; i < resultsTimeStamp.size(); i++) {
                timeStamps[i] = resultsTimeStamp.get(i).toString();
            }
            //}
            URLConnection connectionUser = urlWiki.openConnection();
            connectionUser.setRequestProperty("User-Agent",
                    "Revision Tracker/0.1 (http://www.cs.bsu.edu/~pvg/courses/cs222Sp21; arhupe@bsu.edu)");
            InputStream inputStreamUser = connectionUser.getInputStream();
            JSONArray resultsUsers = JsonPath.read(inputStreamUser, "$..user");
            String[] users = new String[resultsUsers.size()];
            //if(resultsUsers != null) {
            for(int i = 0; i < resultsUsers.size(); i++) {
                users[i] = resultsUsers.get(i).toString();
            }
            //}
            StringBuilder resultsString = new StringBuilder();
            URLConnection connectionRedirect = urlWiki.openConnection();
            connectionRedirect.setRequestProperty("User-Agent",
                    "Revision Tracker/0.1 (http://www.cs.bsu.edu/~pvg/courses/cs222Sp21; arhupe@bsu.edu)");
            InputStream inputStreamRedirect = connectionRedirect.getInputStream();
            JSONArray resultsRedirect = JsonPath.read(inputStreamRedirect, "$..redirect");
            if(resultsRedirect != null) {
                if(resultsRedirect.size() > 0) {
                    resultsString.append("Redirected\n");
                }
            }
            for(int i = 0; i < timeStamps.length; i++) {
                resultsString.append(timeStamps[i]).append(" ");
                if(users[i] != null)
                {
                    resultsString.append(users[i]).append("\n");
                }
            }
            return resultsString.toString();
        }
        catch (Exception e){
            System.out.println("There was a failure" + e);
            System.exit(1);
            throw new RuntimeException(e);
        }
    }
}