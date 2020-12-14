package com.medical.telemedicine.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.av.smoothviewpager.Smoolider.SmoothViewpager;
import com.medical.telemedicine.R;
import com.medical.telemedicine.activities.BookAppointmentActivity;
import com.medical.telemedicine.adapters.MyAppointmentDataAdapter;
import com.medical.telemedicine.models.Appointment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;



@SuppressLint("ValidFragment")
public class MyAppointmentPagerFragment extends Fragment {

    RecyclerView availabeDoctorRecycleView;
    SmoothViewpager viewpager;


    ArrayList<Appointment> appointmentArraylist;
    Fragment fragment;
    MyAppointmentDataAdapter myappointmentDataAdapter;
    String type;

    public MyAppointmentPagerFragment(String type) {
        this.type = type;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.all_doctor_pager_fragment, container, false);


        appointmentArraylist = new ArrayList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        availabeDoctorRecycleView = rootView.findViewById(R.id.availabeDoctorRecycleView);
        availabeDoctorRecycleView.setLayoutManager(layoutManager);

        // setting adatper
        myappointmentDataAdapter = new MyAppointmentDataAdapter(appointmentArraylist, getActivity(), m_onlistner, type);
        availabeDoctorRecycleView.setItemAnimator(new DefaultItemAnimator());
        availabeDoctorRecycleView.setAdapter(myappointmentDataAdapter);


        // load data inot listivew
        loaAppointmentrlistintoListView();

        return rootView;
    }

    MyAppointmentDataAdapter.onSelectedPlaceListener m_onlistner = new MyAppointmentDataAdapter.onSelectedPlaceListener() {
        @Override
        public void onClick(Appointment videoDetails) {


            startActivity(new Intent(getActivity(), BookAppointmentActivity.class));


        }
    };

    // load data into list view
    public void loaAppointmentrlistintoListView() {
        appointmentArraylist = new ArrayList();

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("array");


            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                Appointment Appointment = new Appointment();
                Appointment.setDate(jo_inside.getString("date"));
                Appointment.setTime(jo_inside.getString("time"));
                Appointment.setDoctor(jo_inside.getString("doctor"));
                Appointment.setType(jo_inside.getString("type"));
                Appointment.setPlace(jo_inside.getString("place"));


                appointmentArraylist.add(Appointment);
            }


            myappointmentDataAdapter.setData(appointmentArraylist);
            myappointmentDataAdapter.notifyDataSetChanged();


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    // load data from asset
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("appointment.json");
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
