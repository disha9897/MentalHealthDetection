package com.mentalhealthdetection;

import static java.lang.System.exit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginPage extends AppCompatActivity
{
    EditText name;
    EditText email;
    EditText phone;
    Button submit;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        submit = (Button) findViewById(R.id.submit);
        DB = new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                /*Intent intent = new Intent(getApplicationContext(), MentalHealth.class);
                startActivity(intent);*/

                String u_name = name.getText().toString();
                String u_email = email.getText().toString();
                String u_phone = phone.getText().toString();

                if(u_name.isEmpty() || u_email.isEmpty() || u_phone.isEmpty())
                {
                    Toast.makeText(loginPage.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }

                Boolean checkInsertData = DB.insertData(u_name, u_email, u_phone);
                if(checkInsertData)
                {
                    Toast.makeText(loginPage.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                   // Intent intent1 = new Intent(getApplicationContext(),MentalHealth.class);
                  //  startActivity(intent1);
                }
                else
                {
                    Toast.makeText(loginPage.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }

            /*    if(u_name.equals("")||u_email.equals("")||u_phone.equals(""))
                {

                    Toast.makeText(loginPage.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    //exit(1);
                }
                else
                {
                    if (u_phone != null || u_phone.length() != 10)
                    {
                        Boolean checkuser = DB.checkNameEmailPhone(name,email,phone);
                        if(checkuser==false)
                        {
                            Boolean insert = DB.insertData(u_name, u_email, u_phone);
                            if(insert==true)
                            {
                                Toast.makeText(loginPage.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent1 = new Intent(getApplicationContext(),MentalHealth.class);
                                startActivity(intent1);
                            }else
                            {
                                Toast.makeText(loginPage.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                //exit(1);
                            }
                        }
                        else{
                            Toast.makeText(loginPage.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(loginPage.this, "Please enter valid digits", Toast.LENGTH_SHORT).show();
                    }
                } */
            }
        });
        /*submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MentalHealth.class);
                startActivity(intent);
            }
        });*/
    }
}

       /* public void HealthQue(View view)
         {
             Intent intent = new Intent(this, MentalHealth.class);
             startActivity(intent);
         }*/
