package com.medical.telemedicine.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.av.smoothviewpager.Smoolider.SmoothViewpager;
import com.medical.telemedicine.R;
import com.medical.telemedicine.adapters.AvailableDoctorAdapter;
import com.medical.telemedicine.adapters.SearchListDoctorAdapter;
import com.medical.telemedicine.models.Doctor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SearchListActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    RecyclerView availabeDoctorRecycleView, allDoctorListRCView;
    SmoothViewpager viewpager;

    ArrayList<Doctor> doctorArrayList;
    ArrayList<Doctor> searchDoctorList;
    Fragment fragment;
    AvailableDoctorAdapter availableDoctorAdapter;
    SearchListDoctorAdapter searchListDoctorAdapter;
    Spinner action_bar_spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);


        init();

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Boston");
        categories.add("NewYork");
        categories.add("Silicon");
        categories.add("Georgia");
        categories.add("China");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.action_bar_spinner_title, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        action_bar_spinner.setAdapter(dataAdapter);


        // setup availabedoctor adapter and view
        doctorArrayList = new ArrayList();
        searchDoctorList = new ArrayList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(SearchListActivity.this, LinearLayoutManager.HORIZONTAL, false);
        availabeDoctorRecycleView.setLayoutManager(layoutManager);
        availableDoctorAdapter = new AvailableDoctorAdapter(doctorArrayList, SearchListActivity.this, m_onlistner);
        availabeDoctorRecycleView.setItemAnimator(new DefaultItemAnimator());
        availabeDoctorRecycleView.setAdapter(availableDoctorAdapter);


// setup searchlistdoctor adapater and view
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(SearchListActivity.this, LinearLayoutManager.VERTICAL, false);
        allDoctorListRCView.setLayoutManager(layoutManager1);
        searchListDoctorAdapter = new SearchListDoctorAdapter(searchDoctorList, SearchListActivity.this, null);
        allDoctorListRCView.setItemAnimator(new DefaultItemAnimator());
        allDoctorListRCView.setAdapter(searchListDoctorAdapter);


        // load doctor list
        loadDoctorlistintoListView();

        // load search doctor list
        loadSearchDoctorlistintoListView();
    }

    private void init() {


        // setup toolabr
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView imageView = toolbar.findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        action_bar_spinner = toolbar.findViewById(R.id.action_bar_spinner);
        action_bar_spinner.setOnItemSelectedListener(this);

        availabeDoctorRecycleView = findViewById(R.id.availabeDoctorRecycleView);
        allDoctorListRCView = findViewById(R.id.allDoctorListRCView);


    }

    AvailableDoctorAdapter.onSelectedPlaceListener m_onlistner = new AvailableDoctorAdapter.onSelectedPlaceListener() {
        @Override
        public void onClick(Doctor videoDetails) {


        }
    };


    public void loadSearchDoctorlistintoListView() {
        doctorArrayList = new ArrayList();

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset("searchdoctor.json"));
            JSONArray m_jArry = obj.getJSONArray("array");


            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                Doctor doctor = new Doctor();
                doctor.setName(jo_inside.getString("name"));
                doctor.setSpecialist(jo_inside.getString("specialist"));
                doctor.setTime(jo_inside.getString("time"));
                doctor.setPlace(jo_inside.getString("place"));


                searchDoctorList.add(doctor);
            }


            searchListDoctorAdapter.setData(searchDoctorList);
            searchListDoctorAdapter.notifyDataSetChanged();


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void loadDoctorlistintoListView() {
        doctorArrayList = new ArrayList();

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset("doctor.json"));
            JSONArray m_jArry = obj.getJSONArray("array");


            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                Doctor doctor = new Doctor();
                doctor.setName(jo_inside.getString("name"));
                doctor.setSpecialist(jo_inside.getString("specialist"));
                doctor.setRating(jo_inside.getInt("rating"));
                doctor.setExperience(jo_inside.getString("experience"));
                doctor.setPaitent(jo_inside.getString("paitent"));


                doctorArrayList.add(doctor);
            }


            availableDoctorAdapter.setData(doctorArrayList);
            availableDoctorAdapter.notifyDataSetChanged();


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = SearchListActivity.this.getAssets().open(filename);
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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
