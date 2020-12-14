package com.medical.telemedicine.fragments;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.medical.telemedicine.R;
import com.medical.telemedicine.viewpager.AllDoctorViewPager;
import com.google.android.material.tabs.TabLayout;

public class AllDoctorFragment extends Fragment {


    AllDoctorViewPager allDoctorPayerAdapter;

    ViewPager viewPager;
    TabLayout tabLayout;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.activity_all_doctor, container, false);

        // initialize view
        tabLayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewPager);

        // setting View pager adapter
        allDoctorPayerAdapter = new AllDoctorViewPager(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(allDoctorPayerAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 1) {

                } else if (tab.getPosition() == 2) {

                } else {
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        return view;


    }
}