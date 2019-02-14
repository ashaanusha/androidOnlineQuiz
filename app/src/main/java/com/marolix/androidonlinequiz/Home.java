package com.marolix.androidonlinequiz;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Home  extends Fragment {
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Username="Username";

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);
        getActivity().setTitle("home");

        SharedPreferences pref =this.getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String name = pref.getString(Username, "");
        TextView username=view.findViewById(R.id.Username);
        username.setText(name);
        RecyclerView followed=view.findViewById(R.id.recycle_followed);
        RecyclerView percentage=view.findViewById(R.id.recycle_percentage);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1,LinearLayoutManager.HORIZONTAL);
        followed.setLayoutManager(staggeredGridLayoutManager );
        RecyclerAdapterfollowed  customAdapter1=new RecyclerAdapterfollowed(getActivity(),name);
        followed.setAdapter(customAdapter1);

        percentage.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerAdapterpercentage customAdapter2=new RecyclerAdapterpercentage(getActivity(),name);
        percentage.setAdapter(customAdapter2);
        return view;

    }

}
