package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class InfoActivity extends AppCompatActivity {
TextView question,rq,timertxt;
Button bt1,bt2,bt3,bt4;
private Questions myqustion[];
private int score,r=0;
private CountDownTimer time;
private String yesans,gametype;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //getting the game gategorie from MainActivity2
        Intent intent=getIntent();
        gametype=intent.getStringExtra("categorie");

        switch(gametype){
            case "info": myqustion=new TabQuestions().getQestioninfo();break;
            case "culture": myqustion=new TabQuestions().getQestionculture();break;
            case "sport": myqustion=new TabQuestions().getQestionsport();break;
        }

        //preparing  components
        question=(TextView) findViewById(R.id.qestion);
        bt1=(Button)findViewById((R.id.ans1));
        bt2=(Button)findViewById((R.id.ans2));
        bt3=(Button)findViewById((R.id.ans3));
        bt4=(Button)findViewById((R.id.ans4));
        rq=(TextView) findViewById(R.id.rqtext) ;
        timertxt=(TextView)findViewById(R.id.timer) ;

        //initialize the timer
       time=new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                timertxt.setText("" + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                rq.setText("Time Out ☻ ");
                r++;
                showquestions(r);

            }

        };



    //Starting the game by shwoing the first quistion
    showquestions(r);
    r++;


    //getting the user response and reacting to it
    bt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (bt1.getText() == yesans) {
                rq.setText("nice ♥");
                score+=10;
                showquestions(r++);
            } else {
                rq.setText("wrong ☻ \n the correct answer is: " + yesans);
                showquestions(r++);

            }

        }
    });
    bt2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (bt2.getText() == yesans) {
                rq.setText("nice ♥");
                score+=10;
                showquestions(r++);
            } else {

                rq.setText("wrong ☻ \n the correct answer is: " + yesans);
                showquestions(r++);
            }

        }
    });
    bt3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (bt3.getText() == yesans) {
                rq.setText("nice ♥");
                score+=10;
                showquestions(r++);
            } else {

                rq.setText("wrong ☻ \n the correct answer is: " + yesans);
                showquestions(r++);
            }

        }
    });
    bt4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (bt4.getText() == yesans) {
                rq.setText("nice ♥");
                score+=10;
                showquestions(r++);
            } else {
                rq.setText("wrong ☻ \n the correct answer is: " + yesans);
                showquestions(r++);
            }

        }
    });

}



    public void showquestions(int a){
        if(r==myqustion.length){
            freezGame();
        }else{
            //this line of code  is to make a simple delay by 1s so the user can see the remarques
            new Timer().schedule(new TimerTask(){
                @Override
                public void run(){
                    rq.setText("");
                }

            },1000);

            time.cancel();
            time.start();
        question.setText(myqustion[a].question);
        bt1.setText(myqustion[a].ch1);
        bt2.setText(myqustion[a].ch2);
        bt3.setText(myqustion[a].ch3);
        bt4.setText(myqustion[a].ch4);
        yesans=myqustion[a].rep;
            new Timer().schedule(new TimerTask(){
                @Override
                public void run(){
                    rq.setText("");
                }

            },1000);
        }
    }

    //when the questions are over the game ends and show the Enddilog with the score
    public void outgame(){
        time.cancel();
           Bundle b=new Bundle();
        b.putString("score",""+score);
        Enddilog d=new Enddilog();
        d.setArguments(b);
        d.show(getFragmentManager(),"mydilog");

    }

    private void freezGame(){
        Timer timer=new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                outgame();
            }

        },1300);
    }


}