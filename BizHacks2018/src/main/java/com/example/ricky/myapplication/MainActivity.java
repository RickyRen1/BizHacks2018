package com.example.ricky.myapplication;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String query;
    ArrayList<String> arrItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                BestBuyClient buy = new BestBuyClient("http://bizhacks.bbycastatic.ca/mobile-si/si");
                JSONObject obj;

                obj = buy.getSearch(query,null,null,null,null,null,null,null);
                arrItem = ResponseParser.parseSearch(obj);

            }
        });

        final Button button = findViewById(R.id.button);
        final EditText edittext = findViewById(R.id.searchText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query = edittext.getText().toString();
                Log.v("EditText", query);
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("SEARCH_QUERY", arrItem);
                startActivity(intent);
                /*
                Intent intent = getIntent();
                if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
                    String query = intent.getStringExtra(SearchManager.QUERY);
                    //doSearch(query)
                }
                */
            }
        }

        );

    }
}
