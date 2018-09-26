package Main.edu.bsu.cs222;

import java.util.*;

import java.io.*;

import java.net.URL;

import java.net.URLConnection;


// class checks the internet connection
public class Connection {

    public String testConnection()

    {

        try {

            URL url = new URL("https://en.wikipedia.org");

            URLConnection connection = url.openConnection();

            connection.connect();

            return ("Connected");



        }
// return not connected if failed
        catch (Exception e) {

            return ("Not Connected");

        }

    }



}
// sourced from lauren ravenell
// added comments
// incorporated my own variables