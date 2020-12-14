package com.medical.telemedicine.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.medical.telemedicine.R;
import com.medical.telemedicine.models.Doctor;


import java.util.ArrayList;

public class AvailableDoctorAdapter extends RecyclerView.Adapter<AvailableDoctorAdapter.MyViewHolder> {

    private ArrayList<Doctor> doctorArrayList;
    private onSelectedPlaceListener m_onSelectedPlaceListener;
    Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, specialist, experience, patient;
        ImageView news_img;


        public MyViewHolder(View view) {
            super(view);

            // initiliaze view
            name = (TextView) view.findViewById(R.id.name);
            specialist = (TextView) view.findViewById(R.id.specialist);
            experience = (TextView) view.findViewById(R.id.experience);
            patient = (TextView) view.findViewById(R.id.patient);


        }
    }


    public AvailableDoctorAdapter(ArrayList<Doctor> doctorArrayList, Context context, onSelectedPlaceListener m_onSelectedPlaceListener) {
        this.doctorArrayList = doctorArrayList;
        this.context = context;
        this.m_onSelectedPlaceListener = m_onSelectedPlaceListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_available_doctor_row, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Doctor place = doctorArrayList.get(position);

        try {

            // showing data to view

            holder.name.setText(place.getName());
            holder.specialist.setText(place.getSpecialist());
            holder.experience.setText(place.getExperience());
            holder.patient.setText(place.getPaitent());
            holder.name.setTag(place);
//
//
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Doctor place = (Doctor) holder.name.getTag();
                    m_onSelectedPlaceListener.onClick(place);
                }
            });


        } catch (Exception e) {

        }
    }

    public void setData(ArrayList<Doctor> lst) {
        this.doctorArrayList = lst;
    }

    @Override
    public int getItemCount() {
        return doctorArrayList.size();
    }


    public static double toRad(double value) {
        return value * Math.PI / 180;
    }

    public interface onSelectedPlaceListener {
        void onClick(Doctor place);
    }


    public ArrayList<Doctor> getAllData() {
        return doctorArrayList;
    }

}