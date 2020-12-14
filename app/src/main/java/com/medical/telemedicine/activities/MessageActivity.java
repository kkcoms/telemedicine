package com.medical.telemedicine.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.medical.telemedicine.R;
import com.medical.telemedicine.adapters.MessageListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MessageActivity extends AppCompatActivity {

    MessageListAdapter messageListAdapter;
    ArrayList messageArrrayList;
    RecyclerView messageRecycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        //initialize view
        init();


        // setup messagelistadapter and init recycleivew
        messageArrrayList = new ArrayList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(MessageActivity.this, LinearLayoutManager.VERTICAL, false);
        messageRecycleview.setLayoutManager(layoutManager);
        messageListAdapter = new MessageListAdapter(messageArrrayList, MessageActivity.this, m_onlistner);
        messageRecycleview.setItemAnimator(new DefaultItemAnimator());
        messageRecycleview.setAdapter(messageListAdapter);

        // load message from Asset
        loadMessagestintoListView();
    }

    private void init() {

        // setup tool bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView imageView = toolbar.findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        messageRecycleview = findViewById(R.id.messageRecycleview);



    }

    MessageListAdapter.onSelectedPlaceListener m_onlistner = videoDetails -> {


    };


    public void loadMessagestintoListView() {
        messageArrrayList = new ArrayList();

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("array");


            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                com.medical.telemedicine.models.MessageB doctor = new com.medical.telemedicine.models.MessageB();
                doctor.setName(jo_inside.getString("name"));
                doctor.setMessage(jo_inside.getString("message"));
                doctor.setTime(jo_inside.getString("time"));


                messageArrrayList.add(doctor);
            }


            messageListAdapter.setData(messageArrrayList);
            messageListAdapter.notifyDataSetChanged();


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    // load message from asset
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = MessageActivity.this.getAssets().open("message.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
