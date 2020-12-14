package com.medical.telemedicine.interfaces;

import com.medical.telemedicine.models.Contact;

import java.util.HashMap;



public interface HomeIneractor {
    HashMap<String, Contact> getLocalContacts();
}
