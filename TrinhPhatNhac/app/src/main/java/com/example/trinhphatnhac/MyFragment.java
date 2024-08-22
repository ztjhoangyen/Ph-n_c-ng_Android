package com.example.trinhphatnhac;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.trinhphatnhac.databinding.FragmentMyBinding;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends Fragment {

    FragmentMyBinding fragmentMyBinding;
    private View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentMyBinding = FragmentMyBinding.inflate(inflater, container, false);

        fragmentMyBinding.tvName.setText("OK kaka");

        view = fragmentMyBinding.getRoot();

//        fragmentMyBinding.toolbar.layoutToolbal.setBackgroundColor();

        RecyclerView rcvUser = fragmentMyBinding.rcvUser;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        rcvUser.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
        rcvUser.addItemDecoration(dividerItemDecoration);

////test
//        List<User> users = getListView();
//        Log.d("MyFragment", "Setting up adapter with user list size: " + users.size());


        UserAdapter userAdapter = new UserAdapter(getListView());
        rcvUser.setAdapter(userAdapter);

        return view;
    }

    private  List<User> getListView(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("User 2"));
        userList.add(new User("User 3"));
        userList.add(new User("User 4"));

        Log.d("MyFragment", "User list size: " + userList.size());

        return  userList;
    }
}