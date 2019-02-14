package com.marolix.androidonlinequiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Algebra extends AppCompatActivity {
SharedPreferences sharedPreferences;
DataBaseClass db;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Username="Username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algebra);
        Button play=findViewById(R.id.play);
        Button follow_quiz=findViewById(R.id.follow_quiz);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Algebra.this,Question.class);
                i.putExtra("Subject",getIntent().getStringExtra("Subject"));
                startActivity(i);
            }
        });
        follow_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref =getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                String name = pref.getString(Username, "");
                db.insert_Followed(getIntent().getStringExtra("Subject"),name);
            }
        });
    }
}
