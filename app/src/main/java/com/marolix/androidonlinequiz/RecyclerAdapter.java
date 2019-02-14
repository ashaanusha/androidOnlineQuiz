package com.marolix.androidonlinequiz;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolderClass>  {

    Context context;
    int[] img;
    String[] arr1;
    String subject;


    public RecyclerAdapter(Context mainActivity, int[] img, String[] arr1,String subject) {
        context = mainActivity;
        this.img = img;
        this.arr1 = arr1;
        this.subject=subject;

    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_list, viewGroup, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerAdapter.ViewHolderClass viewHolderClass, int i) {
        viewHolderClass.imageView.setImageResource(img[i]);
        viewHolderClass.textView1.setText(arr1[i]);
viewHolderClass.imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(context,Algebra.class);
        i.putExtra("Subject",subject);
        context.startActivity(i);
    }
});

    }


    @Override
    public int getItemCount() {
        return arr1.length;
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.title);
            textView1 = itemView.findViewById(R.id.text);


        }
    }

}
