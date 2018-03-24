package com.example.ricky.myapplication;

import android.widget.*;

import java.util.ArrayList;

/**
 * Created by nghev01 on 2018-03-24.
 */

public class ItemListEnum {

    private static ItemListEnum itemListEnum = null;

    public static ItemListEnum getItemList() {
        if (itemListEnum == null) {
            itemListEnum = new ItemListEnum();
            itemListEnum.generateProductList();
        }
        return itemListEnum;
    }

    public static ArrayList<Item> arrItemList;
    public static ItemList itemList;
    public static ArrayList<String> productList;

    private void generateProductList() {
        this.arrItemList = new ArrayList<Item>();
        Item item = new Item("ASUS Vivobook 15.6\" Laptop - Grey (Intel Core i5-8250U/1TB SSHD/8GB RAM/Windows 10)",
                Integer.toString(12315119),
                false,
                true,
                "799.99",
                "599.99"
        );
        this.arrItemList.add(item);
        item = new Item("Apple AirPods In-Ear Bluetooth Headphones with Mic (MMEF2C/A) - White",
                Integer.toString(10557542),
                false,
                false,
                "219.99",
                "219.99"
        );
        this.arrItemList.add(item);
        item = new Item("Nintendo Super NES Classic Edition Console)",
                Integer.toString(11470309),
                true,
                false,
                "99.99",
                "99.99"
        );
        this.arrItemList.add(item);
        item = new Item(" MacBook Pro 13 2.5GHz i5 4GB / 500GB - Refurbished, Grade A, Excellent Condition, 9/10",
                Integer.toString(12308129),
                false,
                true,
                "1099.0",
                "$889.0"
        );
        this.arrItemList.add(item);
        item = new Item(" MacBook Pro 15 2.5GHz i5 4GB / 500GB - Refurbished, Grade A, Excellent Condition, 9/10",
                Integer.toString(12308130),
                false,
                true,
                "1099.0",
                "$889.0"
        );
        this.arrItemList.add(item);
        item = new Item(" MacBook Pro 14 2.5GHz i5 4GB / 500GB - Refurbished, Grade A, Excellent Condition, 9/10",
                Integer.toString(12308229),
                false,
                true,
                "1099.0",
                "$889.0"
        );
        this.arrItemList.add(item);
        item = new Item("Samsung 55\" 4K UHD HDR LED Tizen Smart TV (UN55MU6300FXZC) - Dark Titan",
                Integer.toString(10583529),
                false,
                true,
                "849.99",
                "799.99"
        );
        this.arrItemList.add(item);
        item = new Item("Dell 15.6\" Inspiron Touchscreen Laptop - Black (Intel Core i3-7100U/1TB HDD/8GB RAM/Windows 10)",
                Integer.toString(11616659),
                false,
                false,
                "699.99",
                "699.99"
        );
        this.arrItemList.add(item);
        item = new Item("ony 50\" 4K UHD HDR LED Linux Smart TV (KD50X690E)",
                Integer.toString(10583529),
                false,
                false,
                "999.99",
                "999.99"
        );
        this.arrItemList.add(item);

        item = new Item("Refurbished HP 215 AMD A6-1450 1Ghz, 4GB Ram, 500GB Drive, Radeon HD 8250, BTT 4.0, HDMI, Touch, webcam, Win 10 Home",
                Integer.toString(10583529),
                false,
                false,
                "999.99",
                "999.99"
        );


        this.arrItemList.add(item);
        item = new Item("Google Home - White/Slate",
                Integer.toString(10721100),
                false,
                false,
                "179.99",
                "179.99"
        );

        this.arrItemList.add(item);
        item = new Item("Google Home - Black/Slate",
                Integer.toString(10721101),
                false,
                false,
                "179.99",
                "179.99"
        );
        this.arrItemList.add(item);
        item = new Item("Google Home - Green/Slate",
                Integer.toString(20721101),
                false,
                false,
                "179.99",
                "179.99"
        );

        this.arrItemList.add(item);
        item = new Item("Google Home - Blue/Slate",
                Integer.toString(20721201),
                false,
                false,
                "179.99",
                "179.99"
        );
        this.arrItemList.add(item);
        item = new Item("Samsung 55\" 4K UHD HDR LED Tizen Smart TV (UN55MU6300FXZC) - Dark Titan",
                Integer.toString(10721102),
                false,
                false,
                "179.99",
                "179.99"
        );
        this.arrItemList.add(item);
        item = new Item("Nintendo Super NES Limited Edition Console)",
                Integer.toString(11470308),
                true,
                false,
                "1199.99",
                "1199.99"
        );
        this.arrItemList.add(item);


        this.itemList = new ItemList(this.arrItemList);
        this.productList = itemList.getArrayString();
    }
}
