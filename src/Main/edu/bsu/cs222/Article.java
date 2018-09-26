package Main.edu.bsu.cs222;

import java.net.MalformedURLException;

import java.net.URL;

import java.net.URLConnection;

import java.util.Scanner;



import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;


// class that allows user input
    public class Article {

        Scanner reader = new Scanner(System.in);

        String article = reader.next();


// creates a url to the desired article
        public URL Article(String art) throws MalformedURLException {

            URL wikiArticleURL = new URL(formingArticleURL(article));

            return wikiArticleURL;

        }




        // class that forms and article from the wikipedia page
        public String formingArticleURL(String articleName){

            String articleNameForURL = articleName.replaceAll(" ","_");

            String wikiArticle = new String ("https://en.wikipedia.org/wiki/"+articleNameForURL);

            return (wikiArticle);

        }



    }

// sourced from lauren ravenell
// added comments to each class
// changed varibles
// resolved some compiling errors within classes