package com.medical.telemedicine.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.medical.telemedicine.R;

public class DoctorsProfileActivity extends AppCompatActivity {

    LinearLayout linMessage, linVideoCall, linVoiceCall;
    Button bookAnAppointmentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_profile);


        // initialize view
        init();


    }

    private void init() {


        // toolbar setup
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView imageView = toolbar.findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        linVideoCall = findViewById(R.id.linVideoCall);

        linVideoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorsProfileActivity.this, com.medical.telemedicine.activities.MainActivity.class));
            }
        });

        linVoiceCall = findViewById(R.id.linVoiceCall);

        linVoiceCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorsProfileActivity.this, com.medical.telemedicine.activities.MainActivity.class));
            }
        });


        linMessage = findViewById(R.id.linMessage);

        linMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorsProfileActivity.this, MainActivity.class));
            }
        });

        bookAnAppointmentBtn = findViewById(R.id.bookAnAppointmentBtn);
        bookAnAppointmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorsProfileActivity.this, com.medical.telemedicine.activities.BookAppointmentActivity.class));
            }
        });

    }
}
