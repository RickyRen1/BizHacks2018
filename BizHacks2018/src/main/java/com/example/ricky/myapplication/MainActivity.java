package com.example.ricky.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
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

//    private static final int NOTIFICATION_ID = 1;
//    private static final String NOTIFICATION_CHANNEL_ID = "my_notification_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showNotification("Favourite BestBuy Items On-Sale", ItemListEnum.getItemList().generate_favourite_on_sale_items());

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
                //intent.putExtra("SEARCH_RESULT", arrItem);
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

//        NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "default");
//        mBuilder.setSmallIcon(R.drawable.bestbuy_logo);
//        mBuilder.setContentTitle("sale");
//        mBuilder.setContentText("product");
//
//        Notification notify = mBuilder.build();
//        notif.notify(0, notify);
    }

    void showNotification(String title, String content) {
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default",
                    "YOUR_CHANNEL_NAME",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("YOUR_NOTIFICATION_CHANNEL_DISCRIPTION");
            mNotificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "default");
        mBuilder.setSmallIcon(R.drawable.bestbuy_logo); // notification icon
        mBuilder.setContentTitle(title); // title for notification
        mBuilder.setContentText(content);// message for notification
        mBuilder.setAutoCancel(true); // clear notification after click
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pi);
        mNotificationManager.notify(0, mBuilder.build());
    }

}
