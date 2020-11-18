package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
//private Button buttoninfo,buttonculture,buttonsport,testbt;
    private ImageView infoimg,sportimg,cultureimg;
private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        infoimg=(ImageView) findViewById(R.id.infoimg) ;
        sportimg=(ImageView) findViewById(R.id.sportimg) ;
        cultureimg=(ImageView) findViewById(R.id.cultureimg) ;



        infoimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opennext("info");
            }
        });


        cultureimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opennext("culture");
            }
        });

        sportimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opennext("sport");
            }
        });
    }

    public void opennext(String type){
        Intent intent=new Intent(this, InfoActivity.class);
        intent.putExtra("categorie",type);
        startActivity(intent);
    }


}