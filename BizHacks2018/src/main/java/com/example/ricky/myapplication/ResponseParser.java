package com.example.ricky.myapplication;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by nghev01 on 2018-03-24.
 */


public class ResponseParser {

    public static ArrayList<Directory> parseCatelog(JSONObject json) {
        try {
            JSONObject si = json.getJSONObject("si");
            JSONArray arrObj = si.getJSONArray("groups");
            return null;
        } catch (JSONException e) {
            e.getStackTrace();
            return null;

        }
    }

    public static ArrayList<Item> parseSearchItem(JSONObject json) {
        try {
            ArrayList<Item> result = new ArrayList<Item>();
            JSONObject searchAPI = json.getJSONObject("searchApi");
            JSONArray docs = searchAPI.getJSONArray("documents");

            for (int i=0 ; i<docs.length() ; i++) {
                JSONObject doc = docs.getJSONObject(i);
                JSONObject summmary = doc.getJSONObject("summary");
                JSONObject names = summmary.getJSONObject("`names");
                String shortname = names.getString("short");
                String skuId = doc.getString("skuId");
                System.out.println("id: " + skuId + ", names:  " + shortname);
                result.add(new Item ( shortname, skuId));
            }
            return result;
        } catch (JSONException e) {
            System.out.println(e.getMessage());
            return null;

        }
    }

    public static ArrayList<String> parseSearch(JSONObject json) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Item> arrItem = parseSearchItem(json);
        for (int i=0 ;i<arrItem.size() ; i++) {
            Item item = arrItem.get(i);
            result.add(item.getName());
        }
        return result;
    }

}
