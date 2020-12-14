package com.medical.telemedicine.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.medical.telemedicine.R;
import com.vivekkaushik.datepicker.DatePickerTimeline;
import com.vivekkaushik.datepicker.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookAppointmentActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView morning1, morning2, morning3, morning4, morning5, afternoon1, afternoon2, afternoon3, evening1, evening2, evening3, evening4, evening5;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);


// initialize view
        init();

        setSelect(morning1);


        DatePickerTimeline datePickerTimeline = findViewById(R.id.datePickerTimeline);
// Set a Start date (Default, 1 Jan 1970)

        Calendar calendar = Calendar.getInstance();
        //calendar.get(Calendar.YEAR)

        datePickerTimeline.setInitialDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
// Set a date Selected Listener
        datePickerTimeline.setOnDateSelectedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(int year, int month, int day, int dayOfWeek) {
                // Do Something
            }

            @Override
            public void onDisabledDateSelected(int year, int month, int day, int dayOfWeek, boolean isDisabled) {
                // Do Something
            }
        });

// Disable date
        Date[] dates = {Calendar.getInstance().getTime()};
        datePickerTimeline.deactivateDates(dates);


        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("January");
        categories.add("February");
        categories.add("March");
        categories.add("April");
        categories.add("May");
        categories.add("June");
        categories.add("July");
        categories.add("August");
        categories.add("September");
        categories.add("Octobor");
        categories.add("November");
        categories.add("December");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.action_bar_spinner_title, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    // initialize view
    private void init() {

        // toolbar  setup
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView imageView = toolbar.findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        morning1 = findViewById(R.id.morning1);
        morning1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setSelect(morning1);


            }
        });
        morning2 = findViewById(R.id.morning2);
        morning2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setSelect(morning2);


            }
        });
        morning3 = findViewById(R.id.morning3);
        morning3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setSelect(morning3);


            }
        });
        morning4 = findViewById(R.id.morning4);
        morning4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setSelect(morning4);

            }
        });
        morning5 = findViewById(R.id.morning5);
        morning5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setSelect(morning5);

            }
        });
        afternoon1 = findViewById(R.id.afternoon1);
        afternoon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setSelect(afternoon1);

            }
        });
        afternoon2 = findViewById(R.id.afternoon2);
        afternoon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setSelect(afternoon2);

            }
        });
        afternoon3 = findViewById(R.id.afternoon3);
        afternoon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setSelect(afternoon3);

            }
        });
        evening1 = findViewById(R.id.evening1);
        evening1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setSelect(evening1);

            }
        });
        evening2 = findViewById(R.id.evening2);
        evening2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setSelect(evening2);

            }
        });
        evening3 = findViewById(R.id.evening3);
        evening3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setSelect(evening3);

            }
        });
        evening4 = findViewById(R.id.evening4);
        evening4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setSelect(evening4);

            }
        });
        evening5 = findViewById(R.id.evening5);
        evening5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setSelect(evening5);

            }
        });

    }

    // changing background after click
    private void setSelect(TextView textView) {


        morning1.setBackgroundResource(R.drawable.edit_text_bg);
        morning1.setTextColor(Color.BLACK);

        morning2.setBackgroundResource(R.drawable.edit_text_bg);
        morning2.setTextColor(Color.BLACK);

        morning3.setBackgroundResource(R.drawable.edit_text_bg);
        morning3.setTextColor(Color.BLACK);

        morning4.setBackgroundResource(R.drawable.edit_text_bg);
        morning4.setTextColor(Color.BLACK);

        morning5.setBackgroundResource(R.drawable.edit_text_bg);
        morning5.setTextColor(Color.BLACK);

        afternoon1.setBackgroundResource(R.drawable.edit_text_bg);
        afternoon1.setTextColor(Color.BLACK);

        afternoon2.setBackgroundResource(R.drawable.edit_text_bg);
        afternoon2.setTextColor(Color.BLACK);

        afternoon3.setBackgroundResource(R.drawable.edit_text_bg);
        afternoon3.setTextColor(Color.BLACK);

        evening1.setBackgroundResource(R.drawable.edit_text_bg);
        evening1.setTextColor(Color.BLACK);

        evening2.setBackgroundResource(R.drawable.edit_text_bg);
        evening2.setTextColor(Color.BLACK);

        evening3.setBackgroundResource(R.drawable.edit_text_bg);
        evening3.setTextColor(Color.BLACK);

        evening4.setBackgroundResource(R.drawable.edit_text_bg);
        evening4.setTextColor(Color.BLACK);

        evening5.setBackgroundResource(R.drawable.edit_text_bg);
        evening5.setTextColor(Color.BLACK);


        if (textView == morning1) {


            morning1.setBackgroundResource(R.drawable.sign_in_bg_blue);
            morning1.setTextColor(Color.WHITE);


        } else if (textView == morning2) {

            morning2.setBackgroundResource(R.drawable.sign_in_bg_blue);
            morning2.setTextColor(Color.WHITE);


        } else if (textView == morning3) {

            morning3.setBackgroundResource(R.drawable.sign_in_bg_blue);
            morning3.setTextColor(Color.WHITE);


        } else if (textView == morning4) {

            morning4.setBackgroundResource(R.drawable.sign_in_bg_blue);
            morning4.setTextColor(Color.WHITE);


        } else if (textView == morning5) {

            morning5.setBackgroundResource(R.drawable.sign_in_bg_blue);
            morning5.setTextColor(Color.WHITE);


        } else if (textView == afternoon1) {

            afternoon1.setBackgroundResource(R.drawable.sign_in_bg_blue);
            afternoon1.setTextColor(Color.WHITE);


        } else if (textView == afternoon2) {

            afternoon2.setBackgroundResource(R.drawable.sign_in_bg_blue);
            afternoon2.setTextColor(Color.WHITE);


        } else if (textView == afternoon3) {

            afternoon3.setBackgroundResource(R.drawable.sign_in_bg_blue);
            afternoon3.setTextColor(Color.WHITE);


        } else if (textView == evening1) {

            evening1.setBackgroundResource(R.drawable.sign_in_bg_blue);
            evening1.setTextColor(Color.WHITE);


        } else if (textView == evening2) {

            evening2.setBackgroundResource(R.drawable.sign_in_bg_blue);
            evening2.setTextColor(Color.WHITE);


        } else if (textView == evening3) {

            evening3.setBackgroundResource(R.drawable.sign_in_bg_blue);
            evening3.setTextColor(Color.WHITE);


        } else if (textView == evening4) {

            evening4.setBackgroundResource(R.drawable.sign_in_bg_blue);
            evening4.setTextColor(Color.WHITE);


        } else if (textView == evening5) {

            evening5.setBackgroundResource(R.drawable.sign_in_bg_blue);
            evening5.setTextColor(Color.WHITE);


        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
