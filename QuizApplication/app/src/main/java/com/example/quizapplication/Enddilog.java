package com.example.quizapplication;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Enddilog extends DialogFragment {

int flag1;
TextView txtscore;
Button b1,b2;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){

    View view= inflater.inflate(R.layout.customview,container,false);
    txtscore=view.findViewById(R.id.txtScore);
    b1=view.findViewById(R.id.exitbt);
    b2=view.findViewById(R.id.newGamebt);
    String myscore=this.getArguments().getString("score");
    txtscore.setText(myscore);
    b1.setOnClickListener(new View.OnClickListener(){


        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            getActivity().finish();
        }
    });
    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(getActivity(), MainActivity2.class);
            startActivity(intent);
            getActivity().finish();
        }
    });
        return view;
}

}
