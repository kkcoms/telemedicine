package com.medical.telemedicine.interfaces;

import com.medical.telemedicine.models.Message;

import java.util.ArrayList;



public interface OnUserDetailFragmentInteraction {
    void getAttachments();

    ArrayList<Message> getAttachments(int tabPos);

    void switchToMediaFragment();
}
