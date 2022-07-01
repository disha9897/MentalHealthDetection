package com.mentalhealthdetection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MentalHealth4 extends AppCompatActivity {

    RadioButton c1, c2, c3, c4, c5, c6;
    RadioGroup radioGroup, radioGroup2;
    ArrayList<String> answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health4);

        answers=getIntent().getStringArrayListExtra("answers");

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        c1 = (RadioButton) findViewById(R.id.radioButton3);
        c2 = (RadioButton) findViewById(R.id.radioButton4);
        c3 = (RadioButton) findViewById(R.id.radioButton5);

        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup);
        c4 = (RadioButton) findViewById(R.id.radioButton9);
        c5 = (RadioButton) findViewById(R.id.radioButton10);
        c6 = (RadioButton) findViewById(R.id.radioButton11);
    }

    public void nextPage(View view)
    {
        String selected1="",selected2="";
        if((c1.isChecked() || c2.isChecked() || c3.isChecked()) && (c4.isChecked() || c5.isChecked() || c6.isChecked()))
        {
            if(c1.isChecked())
                selected1=c1.getText().toString();
            if(c2.isChecked())
                selected1=c2.getText().toString();
            if(c1.isChecked())
                selected1=c3.getText().toString();
            if(c4.isChecked())
                selected2=c4.getText().toString();
            if(c5.isChecked())
                selected2=c5.getText().toString();
            if(c6.isChecked())
                selected2=c6.getText().toString();

            answers.add(selected1);
            answers.add(selected2);

            Intent intent=new Intent(this,MentalHealth5.class);
            //intent.putExtra("REST2", selectedType);
            intent.putStringArrayListExtra("answers",answers);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Please choose an answer",
                    Toast.LENGTH_SHORT).show();
        }
    }
}