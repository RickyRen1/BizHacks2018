package com.example.ricky.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;


import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ListView list;
    ArrayList<Item> arrItemList;
    ItemList itemList;
    ArrayList<String> productList;
    ArrayList<String> productListSaleStatus;

       private void generateProductList() {
           ItemListEnum itemListEnum = ItemListEnum.getItemList();
           arrItemList = itemListEnum.arrItemList;
           itemList = itemListEnum.itemList;
           productList = itemListEnum.productList;
           productListSaleStatus = itemListEnum.productListSaleStatus;
    }


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
        item = new Item("ASUS Vivobook 15.6\" Laptop - Grey (Intel Core i5-8250U/1TB SSHD/8GB RAM/Windows 10)",
                Integer.toString(12315119),
                false,
                true,
                "599.99",
                "799.99"
        );
        this.arrItemList.add(item);
        item = new Item("Nintendo Super NES Classic Edition Console)",
                Integer.toString(11470309),
                false,
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
        this.itemList = new ItemList(this.arrItemList);
        this.productList = itemList.getArrayString(this.arrItemList);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        generateProductList();
        setContentView(R.layout.activity_search);
        list = (ListView)findViewById(R.id.listView);
        //ArrayList<String> arrList = extras.getStringArrayList("SEARCH_RESULT");
        System.out.println("Creating arrayAdapter");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, productListSaleStatus);
        System.out.println("Setting arrayAdapter to list");
//        ArrayList<Item> items = itemList.getArrayItem();
        list.setAdapter(arrayAdapter);
        list.setItemsCanFocus(false);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        for(int i=0; i<arrItemList.size(); i++) {
            System.out.println(arrItemList.get(i));
            System.out.println(arrItemList.get(i).getName() + " favourite = " + arrItemList.get(i).getFavourite());
        /*    if(arrItemList.get(i).getOnSale() == true) {
                CheckedTextView simpleTextView = (CheckedTextView) findViewById(R.id.checkedTextView1);
                simpleTextView.setBackgroundColor(Color.YELLOW);
            }*/
            if(arrItemList.get(i).getFavourite() == true) {
                list.setItemChecked(i, true);

            }
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView list, View view, int position, long id) {
                System.out.println("item id is " + id);
                System.out.println("item position is " + position);
                System.out.println("item name is " + arrItemList.get((int)id).getName() + " using id");
                System.out.println("item name is " + arrItemList.get(position).getName() + " using position");
                arrItemList.get(position).setFavourite(!(arrItemList.get(position).getFavourite()));


            }
        });
    }
}
