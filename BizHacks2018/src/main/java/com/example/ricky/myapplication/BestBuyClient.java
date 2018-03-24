package com.example.ricky.myapplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import javax.net.ssl.HttpsURLConnection;

import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;

public class BestBuyClient extends Client {


    public BestBuyClient(String domain) {
        super(domain);

    }

    private String appendParams(String domain, String[] params) {
        int len = params.length;
        String rsp = domain;
        for (int i=0 ; i<len ; i++) {
            String param = params[i];
            if (param != null) {
                if (i==0) {
                    rsp += "/" + param;
                } else {
                    rsp += "&" + param;
                }
            }
        }
        return rsp;
    }


    public JSONObject getCategory(String lang) {
        String[] array = new String[1];
        array[0] = lang;
        String urlBuffer = appendParams(this.domain + "/catalog", array );
        URL url;
        try {
            url = new URL(urlBuffer);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

        HttpURLConnection conn;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            JSONObject obj = get(conn);
            if (obj == null) {
                return null;
            }
            System.out.println(obj.toString());
            return obj;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }

    public JSONObject getSearch(String query, String page, String sort, String storeId,
                                  String zipCode, String facetsOnly, String platform, String lang) {
        String[] array = new String[8];
        array[0] = query;
        array[1] = page;
        array[2] = sort;
        array[3]= storeId;
        array[4] = zipCode;
        array[5] = facetsOnly;
        array[6] = platform;
        array[7] = lang;
        String urlBuffer = appendParams(this.domain + "/v3/products/search", array );
        URL url;
        try {
            url = new URL(urlBuffer);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

        HttpURLConnection conn;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            JSONObject obj = get(conn);
            if (obj == null) {
                return null;
            }
            System.out.println(obj.toString());
            return obj;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }


}