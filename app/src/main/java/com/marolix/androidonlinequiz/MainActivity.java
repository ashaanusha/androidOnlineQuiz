package com.marolix.androidonlinequiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
ArrayList<Map<String,String>> data;
DataBaseClass db;
EditText email,password;
String username,pswd;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Username="Username";
    public static final String Pswd="Pswd";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView signup=findViewById(R.id.link_signup);

    email=findViewById(R.id.email1);
    password=findViewById(R.id.password1);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Signup.class);
                startActivity(i);
            }
        });

        Button login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
          username = email.getText().toString().trim();
          pswd = password.getText().toString().trim();
                if (!username.equals("") && !pswd.equals("") )
                {
                    data= new ArrayList<Map<String,String>>();
                    db=new DataBaseClass(getApplicationContext());
                    data=  db.getRetrive(username,pswd);
                    if(!data.isEmpty()) {
                        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(Username, username);
                        editor.commit();
                        Intent i = new Intent(MainActivity.this, MainCategory.class);
                            startActivity(i);
                     }
                     else
                         {
                    Toast.makeText(MainActivity.this, "invalid username and password", Toast.LENGTH_SHORT).show();
                         }
                }
                else{
                    Toast.makeText(MainActivity.this, "enter details", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
