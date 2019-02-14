package com.marolix.androidonlinequiz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class RecyclerAdapterfollowed extends RecyclerView.Adapter<RecyclerAdapterfollowed.ViewHolderClass> {
    Context context;
    String name;
    DataBaseClass db;
    ArrayList<Map<String,String>> data;
    RecyclerAdapterfollowed(Context mainActivity,String name) {
        context = mainActivity;
        this.name=name;
        data= new ArrayList<>();

      db=new DataBaseClass(context);
        data=  db.get_followed(name);
    }

    @NonNull
    @Override
    public RecyclerAdapterfollowed.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.followed, viewGroup, false);
        RecyclerAdapterfollowed.ViewHolderClass viewHolderClass = new RecyclerAdapterfollowed.ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterfollowed.ViewHolderClass viewHolderClass, int i) {

        viewHolderClass.imageView.setImageResource(R.drawable.ic_launcher_background);
        viewHolderClass.textView1.setText(data.get(i).get("FOLLOWED"));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.followed_img);
            textView1 = itemView.findViewById(R.id.followed_text);


        }
    }

}
