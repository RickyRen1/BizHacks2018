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
                JSONObject names = summmary.getJSONObject("names");
                String shortname = names.getString("short");
                String skuId = doc.getString("skuId");
                JSONObject priceBlock = doc.getJSONObject("priceBlock");
                JSONObject itemPrice = priceBlock.getJSONObject("itemPrice");
                String onSale = itemPrice.getString("priceEventType");
                String regularPrice = Double.toString(itemPrice.getDouble("regularPrice"));
                String salePrice;
                Boolean onsale;
                if (onSale.equals( "onsale")) {
                    onsale = true;
                    salePrice = Double.toString(itemPrice.getDouble("currentPrice"));
                } else {
                    onsale = false;
                    salePrice = Double.toString(itemPrice.getDouble("regularPrice"));
                }
                System.out.println("id: " + skuId + ", names:  " + shortname + ", onSale: " + onsale +
                        ", currentPrice: $" + salePrice + ", regularPrice: $" + regularPrice);
                result.add(new Item (shortname, skuId, false, onsale, regularPrice, salePrice));
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
