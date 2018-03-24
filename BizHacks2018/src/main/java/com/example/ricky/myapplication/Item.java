package com.example.ricky.myapplication;


/**
 * Created by nghev01 on 2018-03-23.
 */


public class Item extends Directory {


    boolean favourite;
    boolean onSale;
    String regularPrice;
    String salePrice;


    public Item(String name, String id, boolean favourite, boolean onSale, String regularPrice, String salePrice) {
        super(name, id);
        setFavourite(favourite);
        setOnSale(onSale);
        setRegularPrice(regularPrice);
        setSalePrice(salePrice);

    }

    public void setFavourite(boolean fave) {
        this.favourite = fave;
    }

    public void setOnSale(boolean sale) {
        this.onSale = sale;
    }

    public void setRegularPrice(String sale) {
        this.regularPrice = sale;
    }
    public void setSalePrice(String sale) {
        this.salePrice = sale;
    }

    public boolean getFavourite() {
        return this.favourite;
    }

    public String getRegularPrice() {
        return this.regularPrice;
    }

    public String getSalePrice() {
        return this.salePrice;
    }

    public boolean getOnSale() {
        return this.onSale;
    }
}
