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

public class SearchListDoctorAdapter extends RecyclerView.Adapter<SearchListDoctorAdapter.MyViewHolder> {

    private ArrayList<Doctor> doctorArraylist;
    private onSelectedPlaceListener m_onSelectedPlaceListener;
    Context context;
    String YoutubeAPiKey;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, degree, time, place;


        public MyViewHolder(View view) {
            super(view);

            // initialize view
            name = (TextView) view.findViewById(R.id.name);
            degree = (TextView) view.findViewById(R.id.degree);
            time = (TextView) view.findViewById(R.id.time);
            place = (TextView) view.findViewById(R.id.place);


        }
    }


    public SearchListDoctorAdapter(ArrayList<Doctor> doctorArraylist, Context context, onSelectedPlaceListener m_onSelectedPlaceListener) {
        this.doctorArraylist = doctorArraylist;
        this.context = context;
        this.m_onSelectedPlaceListener = m_onSelectedPlaceListener;

    }

    @Override
    public SearchListDoctorAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_search_list_doctor_row, parent, false);


        return new SearchListDoctorAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SearchListDoctorAdapter.MyViewHolder holder, int position) {
        final Doctor place = doctorArraylist.get(position);

        try {


            // showing data to view
            holder.name.setText(place.getName());
            holder.degree.setText(place.getSpecialist());
            holder.time.setText(place.getTime());
            holder.place.setText(place.getPlace());
            holder.name.setTag(place);


        } catch (Exception e) {

        }
    }

    public void setData(ArrayList<Doctor> lst) {
        this.doctorArraylist = lst;
    }

    @Override
    public int getItemCount() {
        return doctorArraylist.size();
    }


    public static double toRad(double value) {
        return value * Math.PI / 180;
    }

    public interface onSelectedPlaceListener {
        void onClick(Doctor place);
    }


    public ArrayList<Doctor> getAllData() {
        return doctorArraylist;
    }
}