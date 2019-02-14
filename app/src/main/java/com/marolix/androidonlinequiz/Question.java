package com.marolix.androidonlinequiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question extends AppCompatActivity {
TextView b1,b2,b3,b4,q,qno1,time;
    static  int j=0;
    static  int count=0;
    static String subject;
    private DataBaseClass dataBaseClass;
//  static   Set<String> set;
//  static   Set<String> set1;
  static ArrayList<Map<String,String>> al;
//  static ArrayList<String> alA;
//     static SharedPreferences.Editor editor;
 ProgressBar p1;
//    public static final String MyPREFERENCES = "MyPrefs";
//    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
//        try {
//            Uri path = Uri.parse("android.resource://"+getPackageName()+"/raw/alarm.mp3");
//            // The line below will set it as a default ring tone replace
//            // RingtoneManager.TYPE_RINGTONE with RingtoneManager.TYPE_NOTIFICATION
//            // to set it as a notification tone
//            RingtoneManager.setActualDefaultRingtoneUri(
//                    getApplicationContext(), RingtoneManager.TYPE_RINGTONE,
//                    path);
//            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), path);
//            r.play();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
        subject=getIntent().getStringExtra("Subject");
        String question="[\n" +
                "{\n" +
                "  \"Question\": \"What are the indirect Direct subclasses of Services?\",\n" +
                "\"Q1\": \"recognitionService\",\n" +
                "\"Q2\": \" remoteViewsService\",\n" +
                "\"Q3\": \"spellCheckerService\",\n" +
                "\"Q4\": \"inputMethodService\",\n" +
                "\"A\": \"inputMethodService\"\n" +
                "},\n" +
                "{\n" +
                "  \"Question\": \"How many ways to start services?\",\n" +
                "\"Q1\": \"started\",\n" +
                "\"Q2\": \" bound\",\n" +
                "\"Q3\": \"a & b\",\n" +
                "\"Q4\": \"messenger\",\n" +
                "\"A\": \"a & b\"\n" +
                "},\n" +
                "{\n" +
                "  \"Question\": \"Which of the  important device characteristics that you should consider as you design and develop your application?\",\n" +
                "\"Q1\": \"screen size and density\",\n" +
                "\"Q2\": \" input configurations\",\n" +
                "\"Q3\": \" device features\",\n" +
                "\"Q4\": \"all the above\",\n" +
                "\"A\": \"all the above\"\n" +
                "},\n" +
                "{\n" +
                "  \"Question\": \"Parent class of Service?\",\n" +
                "\"Q1\": \"Object\",\n" +
                "\"Q2\": \" Context\",\n" +
                "\"Q3\": \"  ContextWrapper\",\n" +
                "\"Q4\": \"ContextThemeWrapper\",\n" +
                "\"A\": \"ContextWrapper\"\n" +
                "},\n" +
                "{\n" +
                "  \"Question\": \"What are the indirect Direct subclasses of Activity?\",\n" +
                "\"Q1\": \" launcherActivity\",\n" +
                "\"Q2\": \" preferenceActivity\",\n" +
                "\"Q3\": \" tabActivity\",\n" +
                "\"Q4\": \"all the above\",\n" +
                "\"A\": \"all the above\"\n" +
                "},\n" +
                "{\n" +
                "  \"Question\": \"What are the Direct subclasses of Activity?\",\n" +
                "\"Q1\": \"ListActivity\",\n" +
                "\"Q2\": \" ActivityGroup\",\n" +
                "\"Q3\": \" FragmentActivity\",\n" +
                "\"Q4\": \"all the above\",\n" +
                "\"A\": \"all the above\"\n" +
                "},\n" +
                "{\n" +
                "  \"Question\": \"Parent class of Activity?\",\n" +
                "\"Q1\": \"object\",\n" +
                "\"Q2\": \" Context\",\n" +
                "\"Q3\": \"  activityGroup\",\n" +
                "\"Q4\": \"contextThemeWrapper\",\n" +
                "\"A\": \"contextThemeWrapper\"\n" +
                "},\n" +
                "{\n" +
                "  \"Question\": \" Layouts in android?\",\n" +
                "\"Q1\": \"Frame Layout\",\n" +
                "\"Q2\": \" Linear Layout\",\n" +
                "\"Q3\": \" Relative Layout\",\n" +
                "\"Q4\": \"all  of the above\",\n" +
                "\"A\": \"all the above\"\n" +
                "}\n" +
                "]";

        al=new ArrayList<>();
//        alA=new ArrayList<>();
//        set=new HashSet<>();
//        set1=new HashSet<>();
        try {

            JSONArray question1=new JSONArray(question);
            for(int i=0;i<question1.length();i++) {
                Map<String,String> map=new HashMap<>() ;
                JSONObject object = question1.getJSONObject(i);
                String Questionobject=object.getString("Question");
                String q1=object.getString("Q1");
                String q2=object.getString("Q2");
                String q3=object.getString("Q3");
                String q4=object.getString("Q4");
                String A=object.getString("A");
                map.put("Question",Questionobject);
                map.put("q1",q1);
                map.put("q2",q2);
                map.put("q3",q3);
                map.put("q4",q4);
                map.put("A",A);
                al.add(map);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
//        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        q=findViewById(R.id.question);
        time=findViewById(R.id.time);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        p1=findViewById(R.id.p1);
        qno1=findViewById(R.id.qno);

        qno1.setText("Question " + (j+1) + " of 8");


        q.setText(al.get(j).get("Question"));
        b1.setText(al.get(j).get("q1"));
        b2.setText(al.get(j).get("q2"));
        b3.setText(al.get(j).get("q3"));
        b4.setText(al.get(j).get("q4"));
        dataBaseClass = new DataBaseClass(Question.this);
        String q1 = q.getText().toString();
        String A =al.get(j).get("A");

        dataBaseClass.insertValues1(q1, A);
       if(j<al.size()-1)
       {

           new CountDownTimer(9000, 1000) {

               public void onTick(long millisUntilFinished) {
                   time.setText("Seconds remaining:" + millisUntilFinished / 1000);

           b1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(b1.getText().equals(al.get(j).get("A"))) {
                       count++;
                   }
                   dataBaseClass.updateData1(b1.getText().toString(),q.getText().toString());

//                        alA.add(b1.getText().toString());
//                        alA.add( al.get(j).get("Question"));
//                        alA.add(al.get(j).get("A"));
//                        set.add(b1.getText().toString());
                       Intent i = getIntent();
                       i.putExtra("Subject",subject);
                       b1.setBackgroundColor(Color.GREEN);
                       j++;
                       startActivity(i);

               }
           });

           b2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(b2.getText().equals(al.get(j).get("A"))) {
                       count++;
                   }
                   dataBaseClass.updateData1(b2.getText().toString(),q.getText().toString());
//                   alA.add(b2.getText().toString());
//                   alA.add(al.get(j).get("Question"));
//                   alA.add(al.get(j).get("A"));
                   Intent i=getIntent();
                   j++;
                   b2.setBackgroundColor(Color.GREEN);
                   startActivity(i);
               }
           });

           b3.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(b3.getText().equals(al.get(j).get("A"))) {
                       count++;
                   }
                   dataBaseClass.updateData1(b3.getText().toString(),q.getText().toString());
//                   alA.add(b3.getText().toString());
//                   alA.add(al.get(j).get("Question"));
//                   alA.add(al.get(j).get("A"));
                   Intent i=getIntent();
                   j++;
                   b3.setBackgroundColor(Color.GREEN);
                   startActivity(i);
               }
           });

           b4.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(b4.getText().equals(al.get(j).get("A"))) {
                       count++;
                   }
                   dataBaseClass.updateData1(b4.getText().toString(),q.getText().toString());
//                   alA.add(b4.getText().toString());
//                   alA.add(al.get(j).get("Question"));
//                   alA.add(al.get(j).get("A"));
                   Intent i=getIntent();
                   j++;
                   b4.setBackgroundColor(Color.GREEN);
                   startActivity(i);
               }
           });
               }

               public void onFinish() {
                   Intent i = getIntent();
                   i.putExtra("Subject",subject);
                   j++;
                   startActivity(i);
               }
           }.start();

       }
       else {
           new CountDownTimer(9000, 1000) {

               public void onTick(long millisUntilFinished) {
                   time.setText("Seconds remaining:" + millisUntilFinished / 1000);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                 editor = sharedPreferences.edit();
//
//                set.addAll(alA);
//                editor.putStringSet("selected",set);
//                editor.apply();
                j=0;
                dataBaseClass.updateData1(b1.getText().toString(),q.getText().toString());
                Intent i=new Intent(Question.this,Congratulation.class);
//                i.putExtra("json",al);
//                i.putExtra("slectedAnswer",alA);
                i.putExtra("Subject",subject);
                i.putExtra("score",String.valueOf(count));
                startActivity(i);
            }
        });
           b2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
//                  editor = sharedPreferences.edit();
//                   set.addAll(alA);
//                   editor.putStringSet("selected",set);
//                   editor.apply();
                   j=0;
                   dataBaseClass.updateData1(b2.getText().toString(),q.getText().toString());
                   Intent i=new Intent(Question.this,Congratulation.class);
//                   i.putExtra("json",al);
//                   i.putExtra("slectedAnswer",alA);
                   i.putExtra("Subject",subject);
                   i.putExtra("score",String.valueOf(count));
                   startActivity(i);
               }
           });
           b3.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   j=0;
//                  editor = sharedPreferences.edit();
//                   set.addAll(alA);
//                   Log.e("alA", alA.toString() );
//                   editor.putStringSet("selected",set);
//                   editor.apply();
                   dataBaseClass.updateData1(b3.getText().toString(),q.getText().toString());
                   Intent i=new Intent(Question.this,Congratulation.class);
//                   i.putExtra("json",al);
//                   i.putExtra("slectedAnswer",alA);
                   i.putExtra("Subject",subject);
                   i.putExtra("score",String.valueOf(count));
                   startActivity(i);
               }
           });
           b4.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   j=0;
//                editor = sharedPreferences.edit();
//                   set.addAll(alA);
//                   editor.putStringSet("selected",set);
//                   editor.commit();
                   dataBaseClass.updateData1(b4.getText().toString(),q.getText().toString());
                   Intent i=new Intent(Question.this,Congratulation.class);
//                   i.putExtra("json",al);
//                   i.putExtra("slectedAnswer",alA);
                   i.putExtra("Subject",subject);
                   i.putExtra("score",String.valueOf(count));
                   startActivity(i);
               }
           });
               }

               public void onFinish() {
                   Intent i =new Intent(Question.this,Congratulation.class);
                   i.putExtra("Subject",subject);
                   i.putExtra("score",String.valueOf(count));
                   j=0;
                   startActivity(i);
               }
           }.start();
       }

    }
}
