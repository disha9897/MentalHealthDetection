package com.mentalhealthdetection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void HealthQue (View view)
    {
        Intent intent = new Intent(this, MentalHealth.class);
        startActivity(intent);
    }


}