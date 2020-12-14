package com.medical.telemedicine.fragments;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.av.smoothviewpager.Smoolider.SmoothViewpager;
import com.medical.telemedicine.R;
import com.medical.telemedicine.activities.DoctorsProfileActivity;
import com.medical.telemedicine.adapters.AvailableDoctorAdapter;
import com.medical.telemedicine.viewpager.TopViewPager;
import com.medical.telemedicine.models.Doctor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView availabeDoctorRecycleView;
    SmoothViewpager viewpager;

    ArrayList<Doctor> doctorArraylist;
    Fragment fragment;
    AvailableDoctorAdapter availableDoctorAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.activity_home, container, false);


        doctorArraylist = new ArrayList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        availabeDoctorRecycleView = view.findViewById(R.id.availabeDoctorRecycleView);
        availabeDoctorRecycleView.setLayoutManager(layoutManager);

        // setting adapter
        availableDoctorAdapter = new AvailableDoctorAdapter(doctorArraylist, getActivity(), m_onlistner);
        availabeDoctorRecycleView.setItemAnimator(new DefaultItemAnimator());
        availabeDoctorRecycleView.setAdapter(availableDoctorAdapter);

        // setting viewpager
        viewpager = (SmoothViewpager) view.findViewById(R.id.smoolider);
        viewpager.setAdapter(new TopViewPager(getChildFragmentManager()));


        // load doctor list
        loadDoctorlistintoListView();


        return view;


    }

    AvailableDoctorAdapter.onSelectedPlaceListener m_onlistner = new AvailableDoctorAdapter.onSelectedPlaceListener() {
        @Override
        public void onClick(Doctor videoDetails) {


            startActivity(new Intent(getActivity(), DoctorsProfileActivity.class));

        }
    };

    public void loadDoctorlistintoListView() {
        doctorArraylist = new ArrayList();

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


                doctorArraylist.add(doctor);
            }


            availableDoctorAdapter.setData(doctorArraylist);
            availableDoctorAdapter.notifyDataSetChanged();


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
