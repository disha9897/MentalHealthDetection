package com.mentalhealthdetection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    int dcount=0,mcount=0,ncount=0;
    ArrayList<String> answers;
    ArrayList<String> depressed=new ArrayList<>();
    ArrayList<String> mildDepressed=new ArrayList<>();
    ArrayList<String> notDepressed=new ArrayList<>();
    TextView suggestion;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        suggestion=(TextView)findViewById(R.id.suggestion);
        button=(Button)findViewById(R.id.button2);
        answers=getIntent().getStringArrayListExtra("answers");

        depressed.add("Daily");
        depressed.add("My thoughts do not let me breathe, they bothers me all the time");
        depressed.add("It bothers me a lot that cause me mentally ill");
        depressed.add("I am very stressed about my future and it sometimes cause me severe headache");
        depressed.add("Cannot able to sleep");
        depressed.add("Major depressed");
        depressed.add("Majorly affected");
        depressed.add("I did not support, I just cry and overthink");
        depressed.add("I don't feel hungry");
        depressed.add("I don't like to get social");

        mildDepressed.add("Only at night");
        mildDepressed.add("I overthink");
        mildDepressed.add("I always be on past");
        mildDepressed.add("Sometimes I take tension which is very normal");
        mildDepressed.add("I want to sleep, but my thoughts don't let me");
        mildDepressed.add("Sometimes");
        mildDepressed.add("They don't understands me");
        mildDepressed.add("I console myself");
        mildDepressed.add("I don't take all meal in a day");
        mildDepressed.add("Yes");

        notDepressed.add("Sometimes");
        notDepressed.add("Sometimes I think too much, because of which I can not sleep");
        notDepressed.add("It sometimes bothers me that doesn't have much effect on me");
        notDepressed.add("No, I don't");
        notDepressed.add("Sometimes I sleep well, sometimes not");
        notDepressed.add("Not right now");
        notDepressed.add("Affected but lesser");
        notDepressed.add("I try to involve in different things to overcome from my emotional well-being");
        notDepressed.add("I eat properly");
        notDepressed.add("No");

        for(String s:answers)
        {
            if(depressed.contains(s))
                dcount++;
            else if(mildDepressed.contains(s))
                mcount++;
            else if(notDepressed.contains(s))
                ncount++;
        }

        if(dcount>mcount && dcount>ncount)
        {
            String str="According to your answers You have the symptoms of Depression. For solution to your mental illness please chick on below right button";
            suggestion.setText(str);
        }
        else if(mcount>dcount && mcount>ncount)
        {
            String str="According to your answers You have the symptoms of Mild Depression. If you want a solution please find below button.";
            suggestion.setText(str);
            //button.setVisibility(View.VISIBLE);
        }
        else if(ncount>dcount && ncount>mcount)
        {
            String str="According to your answers You are Fine, Chill Dude.";
            suggestion.setText(str);
            button.setVisibility(View.INVISIBLE);
        }
        else
        {
            suggestion.setText("You are Doomed");
            button.setVisibility(View.INVISIBLE);
            //button.setVisibility(View.GONE);
        }
    }

    public void nextPage(View view){
        Intent intent=new Intent(this,Solution.class);
        startActivity(intent);
    }
}