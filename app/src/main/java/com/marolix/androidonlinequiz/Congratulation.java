package com.marolix.androidonlinequiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Congratulation extends AppCompatActivity {
Button View_Result_Analysis,play_agin,main_menu;
TextView correct,wrong;
int score,percentage;
DataBaseClass db;
    //public static final String Name="Username";
    public static final String MyPREFERENCES = "MyPrefs" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation);
        TextView per=findViewById(R.id.per);
        play_agin=findViewById(R.id.play_again);
        main_menu=findViewById(R.id.main_menu);
        correct=findViewById(R.id.correct);
        wrong=findViewById(R.id.wrong);

        play_agin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Congratulation.this,Algebra.class);
                startActivity(i);
            }
        });
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Congratulation.this,MainCategory.class);
                startActivity(i);
            }
        });


       score=Integer.parseInt(getIntent().getStringExtra("score"));
    percentage=100*score/8;
        per.setText(""+percentage+"%");
        db = new DataBaseClass(Congratulation.this);
        SharedPreferences pref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String name = pref.getString("Username", "as1");
        String subject=getIntent().getStringExtra("Subject");
        db.insert_result(name,subject,String.valueOf(percentage));
        View_Result_Analysis=findViewById(R.id.View_Result_Analysis);
        View_Result_Analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Intent i=new Intent(Congratulation.this,ResultAnalysis.class);
        startActivity(i);
            }
        });
       correct.setText(""+(score)+"correct answers");
        wrong.setText(""+(8-score)+"wrong answers");
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(Congratulation.this,Algebra.class);
        startActivity(i);
    }
}
