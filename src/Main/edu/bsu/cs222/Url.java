package Main.edu.bsu.cs222;

import java.net.*;

import java.io.*;



public class Url {



    public Reader articleSearch(String articleName) throws IOException {

        URL url;

        String articleNameForURL = articleName.replaceAll(" ","_");

        url = new URL ("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" + articleNameForURL + "&r%20vprop=timestamp%7Cuser&rvlimit=25&redirects");



        URLConnection connection = url.openConnection();

        Reader in = new InputStreamReader(connection.getInputStream());



        return in;

    }

}