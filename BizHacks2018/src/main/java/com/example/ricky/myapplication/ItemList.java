package com.example.ricky.myapplication;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nghev01 on 2018-03-24.
 */


public class ItemList {

    public HashMap<String, Item> arrItem;



    public ItemList(ArrayList<Item> map) {
        this.arrItem = new HashMap<String,Item>();
        for (int i=0 ; i<map.size() ; i++) {
            this.addItem(map.get(i));
        }
    }

    public void addItem(Item item) {
        this.arrItem.put(item.getName(), item);
    }

    public void updateItemFavourite(String name, boolean favourite) {
        this.arrItem.get(name).setFavourite(favourite);
    }

    private String generateString(Item item) {
        String result = item.getName();
        result += " CurrentPrice: $" + item.getRegularPrice();
        result += " RegularPrice: $" + item.getSalePrice();
        result += " On Sale: " + item.getOnSale();
        return result;

    }

    public ArrayList<String> getArrayString(ArrayList<Item> arrstr) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i=0 ; i<arrstr.size() ; i++) {
            result.add(arrstr.get(i).getName());
        }
        return result;
    }

    public ArrayList<Item> getArrayItem() {
        ArrayList<Item> result = new ArrayList<Item>();
        for (HashMap.Entry<String, Item> entry : this.arrItem.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().getFavourite());
            result.add(entry.getValue());
        }
        return result;
    }

    public ArrayList<Item> getFavourite(){
        ArrayList<Item> result = new ArrayList<Item>();
        for (HashMap.Entry<String, Item> entry : this.arrItem.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().getFavourite());
            if (entry.getValue().getFavourite()) {
                result.add(entry.getValue());
            }
        }
        return result;
    }


}
