package com.example.ricky.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ListView list;
    String productList[] = { "computer", "tv", "mouse", "games", "asd", "sdf", "sdfds", "asd", "sdf", "sdfds", "asd", "sdf", "sdfds", "asd", "sdf", "sdfds", "asd", "sdf", "sdfds", "asd", "sdf", "sdfds" };
    //Bundle extras = getIntent().getExtras();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        list = (ListView)findViewById(R.id.listView);
        //ArrayList<String> arrList = extras.getStringArrayList("SEARCH_RESULT");
        System.out.println("Creating arrayAdapter");
        //System.out.println("arrList size is " + String.valueOf(arrList.size()));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, productList);
        System.out.println("Setting arrayAdapter to list");
        list.setAdapter(arrayAdapter);
        list.setItemsCanFocus(false);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView list, View view, int position, long id) {
                CheckBox cb;
                System.out.println(id);
                System.out.println(productList[(int) id]);
//                for (int x = 0; x<list.getChildCount();x++){
//                    cb = (CheckBox)list.getChildAt(x).findViewById(R.id.checkBox);
//                    if(cb.isChecked()){
//                        System.out.println(productList[x]);
//                    }
//                }
            }
        });
    }
}
