package com.medical.telemedicine.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.medical.telemedicine.R;
import com.medical.telemedicine.activities.MyAppointmentActivity;
import com.medical.telemedicine.activities.ProfileActivity;
import com.medical.telemedicine.activities.SettingActivity;

public class BottomSheetDialogFragment extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {

    LinearLayout linMyappointment, linProfile, linSettings, linLogOut;

    public static BottomSheetDialogFragment newInstance() {
        return new BottomSheetDialogFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.AppBottomSheetDialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_bottom_sheet, container,
                false);


        // init view
        init(view);


        // get the views and attach the listener

        getDialog().setCanceledOnTouchOutside(true);

        return view;

    }

    private void init(View view) {
        linMyappointment = view.findViewById(R.id.linMyappointment);
        linMyappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MyAppointmentActivity.class));
            }
        });

        linProfile = view.findViewById(R.id.linProfile);

        linProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ProfileActivity.class));
            }
        });

        linSettings = view.findViewById(R.id.linSettings);

        linSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), SettingActivity.class));

            }
        });

        linLogOut = view.findViewById(R.id.linLogOut);

        linLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}