package com.medical.telemedicine;

import android.app.Application;
import android.content.Context;
import androidx.multidex.MultiDex;

import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.google.GoogleEmojiProvider;
import com.medical.telemedicine.receivers.ConnectivityReceiver;

public class BaseApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ConnectivityReceiver.init(this);
//        Fabric.with(this, new Crashlytics());
        EmojiManager.install(new GoogleEmojiProvider());

    }
}
