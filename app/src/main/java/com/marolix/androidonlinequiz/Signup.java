package com.marolix.androidonlinequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    private DataBaseClass dataBaseClass;
    boolean value=false;
    String name,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        dataBaseClass = new DataBaseClass(Signup.this);
        final EditText name = findViewById(R.id.name);
        final EditText email = findViewById(R.id.email);
        final EditText password = findViewById(R.id.password);
        final CheckBox checkBox = findViewById(R.id.checkbox);
       Button signup=findViewById(R.id.signUp);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_str = name.getText().toString().trim();
                String email_str = email.getText().toString().trim();
                String  password_str = password.getText().toString().trim();
                if (!name_str.equals("") && !email_str.equals("")  && !password_str.equals("")&& checkBox.isChecked() ) {

                    value = true;
                    dataBaseClass.insertValues(name_str, email_str, password_str);
                    Intent i=new Intent(Signup.this,MainActivity.class);
                    startActivity(i);
                    Toast.makeText(Signup.this, "successfully saved", Toast.LENGTH_SHORT).show();
                }
               else
                {
                    Toast.makeText(Signup.this, "Plz fill the details", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
