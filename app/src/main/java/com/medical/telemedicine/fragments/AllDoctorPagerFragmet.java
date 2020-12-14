package com.medical.telemedicine.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.av.smoothviewpager.Smoolider.SmoothViewpager;
import com.medical.telemedicine.R;
import com.medical.telemedicine.activities.DoctorsProfileActivity;
import com.medical.telemedicine.adapters.AllDoctorsAdapter;
import com.medical.telemedicine.models.Doctor;
import com.medical.telemedicine.utils.GridSpacingItemDecoration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;



@SuppressLint("ValidFragment")
public class AllDoctorPagerFragmet extends Fragment {

    RecyclerView availabeDoctorRecycleView;
    SmoothViewpager viewpager;


    double diaInch;
    ArrayList<Doctor> doctorArrayList;
    Fragment fragment;
    AllDoctorsAdapter allDoctorAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.all_doctor_pager_fragment, container, false);
        doctorArrayList = new ArrayList();

        // getting device height and widht in dp
        DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;


        // if device width is less than 330 shoing a listview
        if (dpWidth < 330) {

            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            availabeDoctorRecycleView = rootView.findViewById(R.id.availabeDoctorRecycleView);
            availabeDoctorRecycleView.setLayoutManager(layoutManager);
            allDoctorAdapter = new AllDoctorsAdapter(doctorArrayList, getActivity(), m_onlistner);
            availabeDoctorRecycleView.setItemAnimator(new DefaultItemAnimator());
            availabeDoctorRecycleView.setAdapter(allDoctorAdapter);

        } else {


// if device width is highter than 330 shoing a Gridview

            GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
            availabeDoctorRecycleView = rootView.findViewById(R.id.availabeDoctorRecycleView);
            availabeDoctorRecycleView.setLayoutManager(layoutManager);
            allDoctorAdapter = new AllDoctorsAdapter(doctorArrayList, getActivity(), m_onlistner);
            int spanCount = 2; // 3 columns
            int spacing = 20; // 50px
            boolean includeEdge = true;
            availabeDoctorRecycleView.addItemDecoration(new GridSpacingItemDecoration(2, 0, 0));
            availabeDoctorRecycleView.setItemAnimator(new DefaultItemAnimator());
            availabeDoctorRecycleView.setAdapter(allDoctorAdapter);


        }
// load doctor from asset
        loadDoctorlistintoListView();

        return rootView;
    }


    AllDoctorsAdapter.onSelectedPlaceListener m_onlistner = new AllDoctorsAdapter.onSelectedPlaceListener() {
        @Override
        public void onClick(Doctor videoDetails) {
            startActivity(new Intent(getActivity(), DoctorsProfileActivity.class));


        }
    };


    public void loadDoctorlistintoListView() {
        doctorArrayList = new ArrayList();

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
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


            allDoctorAdapter.setData(doctorArrayList);
            allDoctorAdapter.notifyDataSetChanged();


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("doctor.json");
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


}
