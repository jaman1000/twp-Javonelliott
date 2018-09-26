package Test;

import org.junit.Assert;

import org.junit.Test;

import org.xml.sax.SAXException;

import twp.Parser;

import twp.Revision;



import java.io.IOException;

import java.io.InputStream;

import java.util.List;



public class Parser {



@Test

//Testing the number of revisions pulled from Wikipedia



    public void testParse()throws IOException, SAXException {

        Parser parser = new Parser();

        InputStream sampleInput = ( getClass().getClassLoader().getResourceAsStream("sample.json"));

        List<Revision> revisions =parser.parse(sampleInput);

        Assert.assertEquals(4, revisions.size());

    }



}

/// sourced from Lauren Ravenell