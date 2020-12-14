package com.medical.telemedicine.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.medical.telemedicine.R;
import com.medical.telemedicine.models.NotificationModel;

import java.util.ArrayList;

public class NotificationListAdapter extends RecyclerView.Adapter<NotificationListAdapter.MyViewHolder> {

    private ArrayList<NotificationModel> notificationArrayList;
    private onSelectedPlaceListener m_onSelectedPlaceListener;
    Context context;
    String YoutubeAPiKey;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, notification, time;


        public MyViewHolder(View view) {
            super(view);

            // initialize view
            name = (TextView) view.findViewById(R.id.name);
            notification = (TextView) view.findViewById(R.id.message);
            time = (TextView) view.findViewById(R.id.time);

        }
    }


    public NotificationListAdapter(ArrayList<NotificationModel> notificationArrayList, Context context, onSelectedPlaceListener m_onSelectedPlaceListener) {
        this.notificationArrayList = notificationArrayList;
        this.context = context;
        this.m_onSelectedPlaceListener = m_onSelectedPlaceListener;

    }

    @Override
    public NotificationListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_notification_list_row, parent, false);


        return new NotificationListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final NotificationListAdapter.MyViewHolder holder, int position) {
        final NotificationModel place = notificationArrayList.get(position);

        try {


            // showing data to view
            holder.name.setText(place.getTitle());
            holder.notification.setText(place.getMessage());
            holder.time.setText(place.getTime());


        } catch (Exception e) {

        }
    }

    public void setData(ArrayList<NotificationModel> lst) {
        this.notificationArrayList = lst;
    }

    @Override
    public int getItemCount() {
        return notificationArrayList.size();
    }


    public static double toRad(double value) {
        return value * Math.PI / 180;
    }

    public interface onSelectedPlaceListener {
        void onClick(NotificationModel place);
    }


    public ArrayList<NotificationModel> getAllData() {
        return notificationArrayList;
    }
}