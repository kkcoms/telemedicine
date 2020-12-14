package com.medical.telemedicine.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.medical.telemedicine.R;

import com.medical.telemedicine.fragments.BottomSheetDialogFragment;
import com.medical.telemedicine.fragments.AllDoctorFragment;
import com.medical.telemedicine.fragments.HomeFragment;
import com.medical.telemedicine.fragments.NotificationFragment;
import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;

public class Dashboard extends AppCompatActivity {
    BubbleNavigationLinearView nabbar;
    Fragment fragment;
    Toolbar toolbar;
    ImageView searchAction, chatAction;
    LinearLayout mainNav;
    RelativeLayout navNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        //initialize View
        init();

        nabbar.setCurrentActiveItem(0);
        fragment = new HomeFragment();
        loadFragment(fragment);
        setTitleToAppBar(0);


    }

    private void init() {

        // tool bar
        toolbar = (Toolbar) findViewById(R.id.toolbar); // get the reference of Toolbar


        mainNav = toolbar.findViewById(R.id.mainNav);
        navNotification = toolbar.findViewById(R.id.navNotification);

        searchAction = toolbar.findViewById(R.id.searchAction);
        searchAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, com.medical.telemedicine.activities.SearchActivity.class));
            }
        });

        chatAction = toolbar.findViewById(R.id.chatAction);
        chatAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, com.medical.telemedicine.activities.MessageActivity.class));

            }
        });


        // bottom nav bar
        nabbar = findViewById(R.id.bottom_navigation_view_linear);

        nabbar.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                //navigation changed, do something


                if (position == 0) {
                    setTitleToAppBar(position);
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                } else if (position == 1) {
                    setTitleToAppBar(position);
                    fragment = new AllDoctorFragment();
                    loadFragment(fragment);
                } else if (position == 2) {
                    setTitleToAppBar(position);
                    fragment = new NotificationFragment();
                    loadFragment(fragment);
                } else if (position == 3) {
                    setTitleToAppBar(position);

                    // bottom dialog sheet
                    BottomSheetDialogFragment bottomSheetDialogFragment =
                            BottomSheetDialogFragment.newInstance();
                    bottomSheetDialogFragment.show(getSupportFragmentManager(),
                            "add_photo_dialog_fragment");


                }
            }
        });



    }

    // settitle to toolbar
    private void setTitleToAppBar(int position) {


        try {
            TextView appbartext = toolbar.findViewById(R.id.appbartext);

            mainNav.setVisibility(View.VISIBLE);
            navNotification.setVisibility(View.GONE);

            if (position == 0) {
                appbartext.setText("Find Your");

            } else if (position == 1) {
                appbartext.setText("Available");

            } else if (position == 2) {
                //appbartext.setText("Notification");
                mainNav.setVisibility(View.GONE);
                navNotification.setVisibility(View.VISIBLE);

            } else if (position == 3) {

            }


        } catch (Exception e) {

        }
    }

    // load fragment
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

}
