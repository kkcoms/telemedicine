package com.medical.telemedicine.services;


import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
  @Override
  public void onTokenRefresh() {
    super.onTokenRefresh();
  }
}
