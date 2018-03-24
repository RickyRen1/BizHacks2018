package com.example.ricky.myapplication;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        final EditText edittext = findViewById(R.id.searchText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = edittext.getText().toString();
                Log.v("EditText", query);
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("SEARCH_QUERY", query);
                startActivity(intent);
                /*
                Intent intent = getIntent();
                if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
                    String query = intent.getStringExtra(SearchManager.QUERY);
                    //doSearch(query)
                }
                */
            }
        });
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                BestBuyClient buy = new BestBuyClient("http://bizhacks.bbycastatic.ca/mobile-si/si");
                JSONObject obj = buy.getCategory(null);

                obj = buy.getSearch(null,null,null,null,null,null,null,null);
                ArrayList<String> arrItem = ResponseParser.parseSearch(obj);

            }
        });

    }
}
