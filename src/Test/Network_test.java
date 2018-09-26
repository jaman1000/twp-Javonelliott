package Test;


import org.junit.Assert;

import org.junit.Test;



import twp.NetworkConnection;



public class NetworkConnectionTest {



    @Test

    public void testIsConnected(){

        NetworkConnectionTest network = new NetworkConnectionTest();

        String response = network.testConnection();

        Assert.assertEquals("Connected", response);

    }



    @Test

    public void testIsNotConnected() {

        NetworkConnectionTest network = new NetworkConnectionTest();

        String response = network.testConnection();

        Assert.assertEquals("Not Connected", response);

    }







}