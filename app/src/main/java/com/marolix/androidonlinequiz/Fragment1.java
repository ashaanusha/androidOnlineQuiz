package com.marolix.androidonlinequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class Fragment1 extends Fragment {

    CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    TextView head1,head2,head3,head4;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        checkBox1=view.findViewById(R.id.checkbox1);
        checkBox2=view.findViewById(R.id.checkbox2);
        checkBox3=view.findViewById(R.id.checkbox3);
        checkBox4=view.findViewById(R.id.checkbox4);
        head1=view.findViewById(R.id.head1);
        head2=view.findViewById(R.id.head2);
        head3=view.findViewById(R.id.head3);
        head4=view.findViewById(R.id.head4);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Intent i=new Intent(getActivity(),Subcategories.class);
                    i.putExtra("Subject",head1.getText());
                    startActivity(i);
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Intent i=new Intent(getActivity(),Subcategories.class);
                    i.putExtra("Subject",head2.getText());
                    startActivity(i);
                }
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Intent i=new Intent(getActivity(),Subcategories.class);
                    i.putExtra("Subject",head3.getText());
                    startActivity(i);
                }
            }
        });

        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Intent i=new Intent(getActivity(),Subcategories.class);
                    i.putExtra("Subject",head4.getText());
                    startActivity(i);
                }
            }
        });
        return view;

    }

}
