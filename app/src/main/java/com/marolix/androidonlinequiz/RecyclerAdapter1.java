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

public class RecyclerAdapter1 extends RecyclerView.Adapter<RecyclerAdapter1.ViewHolderClass> {
    Context context;
 ArrayList<Map<String,String>> data ;
    RecyclerAdapter1(Context context,ArrayList<Map<String,String>> data)
    {
        this.context=context;
        this.data=data;

    }

    @NonNull
    @Override
    public RecyclerAdapter1.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_list1, viewGroup, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter1.ViewHolderClass viewHolderClass, int i) {

        viewHolderClass.question.setText(data.get(i).get(DataBaseClass.QUESTION));
        viewHolderClass.correct.setText("Correct Answer :"+data.get(i).get(DataBaseClass.ANSWER));
        viewHolderClass.selected.setText("Wrong Answer :"+data.get(i).get(DataBaseClass.SELECTED));
if(data.get(i).get(DataBaseClass.ANSWER).equals(data.get(i).get(DataBaseClass.SELECTED)))
{
    viewHolderClass.imageView.setImageResource(R.drawable.tick);
}

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView question,correct,selected;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img1);
            question = itemView.findViewById(R.id.question1);
            correct = itemView.findViewById(R.id.correct1);
            selected = itemView.findViewById(R.id.selected1);

        }
    }
}
