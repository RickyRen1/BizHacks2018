package com.example.ricky.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ListView list;
    String productList[] = { "computer", "tv", "mouse", "games", "asd", "sdf", "sdfds", "asd", "sdf", "sdfds", "asd", "sdf", "sdfds", "asd", "sdf", "sdfds", "asd", "sdf", "sdfds", "asd", "sdf", "sdfds" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        list = (ListView)findViewById(R.id.listView);
        System.out.println("Creating arrayAdapter");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.textView, productList);
        System.out.println("Setting arrayAdapter to list");
        list.setAdapter(arrayAdapter);

    }

}
