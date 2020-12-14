package com.medical.telemedicine.interfaces;

import com.medical.telemedicine.models.Message;



public interface OnMessageItemClick {
    void OnMessageClick(Message message, int position);

    void OnMessageLongClick(Message message, int position);
}
