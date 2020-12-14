package com.medical.telemedicine.fragments;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.medical.telemedicine.R;
import com.medical.telemedicine.adapters.NotificationListAdapter;
import com.medical.telemedicine.models.NotificationModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class NotificationFragment extends Fragment {

    NotificationListAdapter NotificationListAdapter;
    RecyclerView notificationRecycleView;
    ArrayList<NotificationModel> notificationArraylist;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.activity_notification, container, false);


        notificationArraylist = new ArrayList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        notificationRecycleView = view.findViewById(R.id.notificationRecycleView);
        notificationRecycleView.setLayoutManager(layoutManager);

        // setting adapter
        NotificationListAdapter = new NotificationListAdapter(notificationArraylist, getActivity(), null);
        notificationRecycleView.setItemAnimator(new DefaultItemAnimator());
        notificationRecycleView.setAdapter(NotificationListAdapter);

        // load notification
        loadNotificationlistintoListView();


        return view;


    }

    // load data to view
    public void loadNotificationlistintoListView() {
        notificationArraylist = new ArrayList();

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("array");


            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                NotificationModel doctor = new NotificationModel();
                doctor.setTitle(jo_inside.getString("title"));
                doctor.setMessage(jo_inside.getString("message"));
                doctor.setTime(jo_inside.getString("time"));


                notificationArraylist.add(doctor);
            }


            NotificationListAdapter.setData(notificationArraylist);
            NotificationListAdapter.notifyDataSetChanged();


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    // load data from asset
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("notification.json");
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
