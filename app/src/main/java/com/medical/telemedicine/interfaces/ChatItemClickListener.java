package com.medical.telemedicine.interfaces;

import android.view.View;

import com.medical.telemedicine.models.Group;
import com.medical.telemedicine.models.User;



public interface ChatItemClickListener {
    void onChatItemClick(String chatId, String chatName, int position, View userImage);

    void onChatItemClick(Group group, int position, View userImage);

    void placeCall(boolean callIsVideo, User user);
}
