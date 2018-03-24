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
