package com.mentalhealthdetection;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context)    // it will create database in the DB
    {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB)
    {
        MyDB.execSQL("create Table users(name TEXT, email TEXT primary key, phone NUMBER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1)
    {
        MyDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String name, String email, String number)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email",email);
        contentValues.put("number", number);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1)   // -1 indicates failure
            return false;
        else
            return true;
    }

   /* public Boolean checkName(String name)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where name = ?", new String[] {name});
        if (cursor.getCount() > 0)
            return true;    // if true then user exists
        else
            return false;
    }


    public Boolean checkNameEmail(EditText name, EditText email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where name = ? and email = ?", new String[]{String.valueOf(name), String.valueOf(email)});
        if (cursor.getCount() > 0)
            return true;    // if true then user exists
        else
            return false;
    }

    public Boolean checkNameEmailPhone(EditText name, EditText email, EditText phone) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where name = ? and email = ? and phone = ?" , new String[]{String.valueOf(name), String.valueOf(email), String.valueOf(phone)});
        if (cursor.getCount() > 0)
            return true;    // if true then user exists
        else
            return false;
    }*/
}
