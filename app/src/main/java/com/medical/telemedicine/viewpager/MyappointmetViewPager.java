package com.medical.telemedicine.viewpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.medical.telemedicine.fragments.MyAppointmentPagerFragment;


public class MyappointmetViewPager extends FragmentPagerAdapter {

    private int numOfTabs;


    public MyappointmetViewPager(FragmentManager fm, int tabCount) {
        super(fm);
        this.numOfTabs = tabCount;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MyAppointmentPagerFragment("Upcoming");

            case 1:
                return new MyAppointmentPagerFragment("Past");


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
