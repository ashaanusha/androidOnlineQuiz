package com.marolix.androidonlinequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

public class Subcategories extends AppCompatActivity {
    private RecyclerView recyclerView;
    int[] img={R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
    String[] arr1={"Algebra","Matrix","Equations","Geometry","Probability"};
    ArrayAdapter<String> adapter;
    RecyclerAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategories);
        String subject=getIntent().getStringExtra("Subject");

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        customAdapter=new RecyclerAdapter(Subcategories.this,img,arr1,subject);
        recyclerView.setAdapter(customAdapter);
    }
}
