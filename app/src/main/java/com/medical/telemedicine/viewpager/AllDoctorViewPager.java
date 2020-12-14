package com.medical.telemedicine.viewpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.medical.telemedicine.fragments.AllDoctorPagerFragmet;



public class AllDoctorViewPager extends FragmentPagerAdapter {

    private int numOfTabs;


    public AllDoctorViewPager(FragmentManager fm, int tabCount) {
        super(fm);
        this.numOfTabs = tabCount;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AllDoctorPagerFragmet();

            case 1:
                return new AllDoctorPagerFragmet();

            case 2:
                return new AllDoctorPagerFragmet();

            case 3:
                return new AllDoctorPagerFragmet();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
