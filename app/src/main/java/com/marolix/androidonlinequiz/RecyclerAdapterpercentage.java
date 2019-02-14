package com.marolix.androidonlinequiz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class RecyclerAdapterpercentage extends RecyclerView.Adapter<RecyclerAdapterpercentage.ViewHolderClass> {
    Context context;
    String name;
    DataBaseClass db;
    ArrayList<Map<String,String>> data;
    RecyclerAdapterpercentage(Context mainActivity,String name) {
        context = mainActivity;
        this.name=name;


    }

    @NonNull
    @Override
    public RecyclerAdapterpercentage.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.percentage, viewGroup, false);
        RecyclerAdapterpercentage.ViewHolderClass viewHolderClass = new RecyclerAdapterpercentage.ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterpercentage.ViewHolderClass viewHolderClass, int i) {
        data= new ArrayList<>();
        db=new DataBaseClass(context);
        data = db.getResult(name);
        viewHolderClass.per_img.setImageResource(R.drawable.ic_launcher_background);
        String subject=data.get(i).get("SUBJECT");
      //  viewHolderClass.per_head.setText(subject);
        viewHolderClass.per_text.setText(data.get(i).get("PERCENTAGE")+" % in all quiz attempts");
//       int value=Integer.parseInt(data.get(i).get("PERCENTAGE"));
//        viewHolderClass.per_progress.setProgress(value);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder {
        ImageView per_img;
        TextView per_head;
        TextView per_text;
        ProgressBar per_progress;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            per_img = itemView.findViewById(R.id.per_img);
            per_head = itemView.findViewById(R.id.per_head);
            per_text = itemView.findViewById(R.id.per_text);
            per_progress = itemView.findViewById(R.id.per_progress);

        }
    }
}
