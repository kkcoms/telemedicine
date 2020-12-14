package com.medical.telemedicine.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.medical.telemedicine.R;
import com.medical.telemedicine.adapters.GroupsAdapter;
import com.medical.telemedicine.interfaces.UserGroupSelectionDismissListener;
import com.medical.telemedicine.models.Group;
import com.medical.telemedicine.utils.Helper;
import com.medical.telemedicine.utils.SharedPreferenceHelper;
import com.medical.telemedicine.views.MyRecyclerView;

import java.util.ArrayList;


public class GroupSelectDialogFragment extends BaseFullDialogFragment {
    private TextView heading;
    private EditText query;
    private MyRecyclerView recyclerView;
    private ArrayList<Group> myGroups;

    public GroupSelectDialogFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group_select, container);
        heading = view.findViewById(R.id.heading);
        heading.setText("Groups");
        query = view.findViewById(R.id.searchQuery);
        query.setHint("Send to:");

        recyclerView = view.findViewById(R.id.recycler_view);

        recyclerView.setEmptyView(view.findViewById(R.id.emptyView));
        recyclerView.setEmptyImageView(((ImageView) view.findViewById(R.id.asset_1)));
        TextView emptyTextView = view.findViewById(R.id.emptyText);
        emptyTextView.setText(getString(R.string.no_groups));
        recyclerView.setEmptyTextView(emptyTextView);

        view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        view.findViewById(R.id.createGroup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper(getContext());
                sharedPreferenceHelper.setBooleanPreference(Helper.GROUP_CREATE, true);
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new GroupsAdapter(getActivity(), myGroups));
    }

    public static GroupSelectDialogFragment newInstance(Context context, ArrayList<Group> myGroups) {
        GroupSelectDialogFragment dialogFragment = new GroupSelectDialogFragment();
        dialogFragment.myGroups = myGroups;
        if (context instanceof UserGroupSelectionDismissListener) {
            dialogFragment.dismissListener = (UserGroupSelectionDismissListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement UserGroupSelectionDismissListener");
        }
        return dialogFragment;
    }

}
