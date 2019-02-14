package com.marolix.androidonlinequiz;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class ResultAnalysis extends AppCompatActivity {
RecyclerView recyclerView;
RecyclerAdapter1 customAdapter;
String question[];
ArrayList<Map<String,String>> data;
int i=0;
//    public static final String MyPREFERENCES = "MyPrefs" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_analysis);
        recyclerView=findViewById(R.id.recycle);
        data= new ArrayList<>();

        DataBaseClass db=new DataBaseClass(getApplicationContext());
        data=  db.getRetrive1();

////        SharedPreferences pref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
//        Set<String> selected = pref.getStringSet("selected", null);
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.addAll(selected);
//        while(i<arrayList.size())
//        {
//          question[j]=  arrayList.get(i);
//          ans[j]=  arrayList.get(i+1);
//           sel[j]=  arrayList.get(i+2);
//           i=i+3;
//           j++;
//        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customAdapter=new RecyclerAdapter1(this,data);
        recyclerView.setAdapter(customAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));

    }
}
