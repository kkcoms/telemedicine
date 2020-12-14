package com.medical.telemedicine.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.medical.telemedicine.R;
import com.medical.telemedicine.models.Doctor;

import java.util.ArrayList;

public class AllDoctorsAdapter extends RecyclerView.Adapter<AllDoctorsAdapter.MyViewHolder> {

    private ArrayList<Doctor> doctorArrayList;
    private onSelectedPlaceListener m_onSelectedPlaceListener;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, specialist, experience, patient;


        public MyViewHolder(View view) {
            super(view);

            // initialize view
            name = (TextView) view.findViewById(R.id.name);
            specialist = (TextView) view.findViewById(R.id.specialist);
            experience = (TextView) view.findViewById(R.id.experience);
            patient = (TextView) view.findViewById(R.id.patient);

        }
    }


    public AllDoctorsAdapter(ArrayList<Doctor> doctorArrayList, Context context, onSelectedPlaceListener m_onSelectedPlaceListener) {
        this.doctorArrayList = doctorArrayList;
        this.context = context;
        this.m_onSelectedPlaceListener = m_onSelectedPlaceListener;
    }

    @Override
    public AllDoctorsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_all_available_doctor_row, parent, false);


        return new AllDoctorsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AllDoctorsAdapter.MyViewHolder holder, int position) {
        final Doctor place = doctorArrayList.get(position);

        try {

// showing data to view
            holder.name.setText(place.getName());
            holder.specialist.setText(place.getSpecialist());
            holder.experience.setText(place.getExperience());
            holder.patient.setText(place.getPaitent());
            holder.name.setTag(place);

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


    public interface onSelectedPlaceListener {
        void onClick(Doctor place);
    }


    public ArrayList<Doctor> getAllData() {
        return doctorArrayList;
    }
}