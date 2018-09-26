package Main.edu.bsu.cs222;

import com.google.gson.JsonArray;

import com.google.gson.JsonElement;

import com.google.gson.JsonObject;

import com.google.gson.JsonParser;



import java.io.*;

import java.sql.Timestamp;

import java.util.*;
import java.util.List;


public class Parser {

    JsonObject rootObject;





    public Parser(String articleName) {

        JsonParser parser = new JsonParser();

        Url urlReader = new Url();

        Reader reader = null;



        try {

            reader = urlReader.articleSearch(articleName);

        } catch (IOException e) {

            e.printStackTrace();

        }

        JsonElement rootElement = parser.parse(reader);

        this.rootObject = rootElement.getAsJsonObject();

    }





    public List<Revision> getRevisions() {

        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");

        JsonArray array = null;

        for (Map.Entry<String, JsonElement> entry : pages.entrySet()) {

            JsonObject entryObject = entry.getValue().getAsJsonObject();

            array = entryObject.getAsJsonArray("revisions");

        }

        List<Revision> revisionList = new ArrayList<Revision>();



        for (int i = 0; i < array.size(); i++) {

            Revision revision = new Revision(getUsername(array, i), getTime(array, i));

            revisionList.add(revision);

        }

        return revisionList;



    }



    public String getUsername(JsonArray array, int i) {

        String username = array.get(i).getAsJsonObject().get("user").toString().replaceAll("\"", "");

        return username;

    }



    public Timestamp convertToTime(String timeString) {

        timeString = timeString.replace("Z", "");

        timeString = timeString.replace("T", " ");

        Timestamp time = Timestamp.valueOf(timeString);

        return time;

    }



    public Timestamp getTime(JsonArray array, int i) {

        String timeString = array.get(i).getAsJsonObject().get("timestamp").toString().replaceAll("\"", "");

        Timestamp time = convertToTime(timeString);

        return time;

    }



    public String doesRedirects(){

        if(rootObject.has("redirects")) {

            JsonObject redirects = rootObject.getAsJsonObject("query").getAsJsonArray("redirects").get(0).getAsJsonObject();

            String redirectToArticle = redirects.get("to").toString();

            return redirectToArticle;

        }

        return "Does not Redirect";

    }

}
/// sourced from video tutorials.