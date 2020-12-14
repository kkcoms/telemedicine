package com.medical.telemedicine.adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.medical.telemedicine.R;
import com.medical.telemedicine.models.Appointment;

import java.util.ArrayList;

public class MyAppointmentDataAdapter extends RecyclerView.Adapter<MyAppointmentDataAdapter.MyViewHolder> {

    private ArrayList<Appointment> appointmentArraylist;
    private onSelectedPlaceListener m_onSelectedPlaceListener;
    Context context;

    String type = "";

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView date, time, doctor, appointmenttype, place;
        Button appontButton;


        public MyViewHolder(View view) {
            super(view);
            // initialize view
            date = (TextView) view.findViewById(R.id.date);
            time = (TextView) view.findViewById(R.id.time);
            doctor = (TextView) view.findViewById(R.id.doctor);
            appointmenttype = (TextView) view.findViewById(R.id.appointmenttype);
            appontButton = (Button) view.findViewById(R.id.appontButton);

        }
    }


    public MyAppointmentDataAdapter(ArrayList<Appointment> appointmentArraylist, Context context, onSelectedPlaceListener m_onSelectedPlaceListener, String type) {
        this.appointmentArraylist = appointmentArraylist;
        this.context = context;
        this.m_onSelectedPlaceListener = m_onSelectedPlaceListener;
        this.type = type;
    }

    @Override
    public MyAppointmentDataAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_myappointment_list_row, parent, false);


        return new MyAppointmentDataAdapter.MyViewHolder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(final MyAppointmentDataAdapter.MyViewHolder holder, int position) {
        final Appointment place = appointmentArraylist.get(position);

        try {

// showing data to view
            holder.date.setText(place.getDate());
            holder.time.setText(place.getTime());
            holder.doctor.setText(place.getDoctor());
            holder.appointmenttype.setText(place.getType());
            holder.date.setTag(place);

            if (type.equals("Upcoming")) {
                holder.appontButton.setText("Cancel");
                holder.appontButton.setBackgroundResource(R.drawable.cancel_btn_bg);
            }
//
//
            holder.appontButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Appointment place = (Appointment) holder.date.getTag();
                    m_onSelectedPlaceListener.onClick(place);
                }
            });
//


        } catch (Exception e) {

        }
    }

    public void setData(ArrayList<Appointment> lst) {
        this.appointmentArraylist = lst;
    }

    @Override
    public int getItemCount() {
        return appointmentArraylist.size();
    }


    public static double toRad(double value) {
        return value * Math.PI / 180;
    }

    public interface onSelectedPlaceListener {
        void onClick(Appointment place);
    }


    public ArrayList<Appointment> getAllData() {
        return appointmentArraylist;
    }
}