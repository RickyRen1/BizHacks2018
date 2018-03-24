package com.example.nghev01.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;

/**
 * Created by nghev01 on 2018-03-23.
 */

public class Client {

    String domain;

    public Client(String domain) {
        this.domain = domain;
        System.out.println("this is the domain" + this.domain);

    }

    public JSONObject get(HttpURLConnection conn) {
        try {

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            String json = "";
            while ((output = br.readLine()) != null) {
                json += output;
            }
            try {
                JSONObject myResponse = new JSONObject(json.toString());
                return myResponse;
            } catch (JSONException e) {
                System.out.println(e.getStackTrace());
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
