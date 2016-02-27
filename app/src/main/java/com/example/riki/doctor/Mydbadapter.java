package com.example.riki.doctor;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.service.textservice.SpellCheckerService;
import android.widget.Toast;

/**
 * Created by Riki on 17/12/2015.
 */
public class Mydbadapter {
    MyDbhelper myDbhelper;
    Context context;

    public Mydbadapter(Context context){
        myDbhelper=new MyDbhelper(context);
    }


    //INSERT DATA


    long insertdata(String Name,String Dob,String Mobile_no,String Email,String Password,String Gender, String City){
        SQLiteDatabase sqLiteDatabase=myDbhelper.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(MyDbhelper.Name,Name);
        contentValues.put(MyDbhelper.Dob,Dob);
        contentValues.put(MyDbhelper.Mobile_no,Mobile_no);
        contentValues.put(MyDbhelper.Email,Email);
        contentValues.put(MyDbhelper.Password,Password);
        contentValues.put(MyDbhelper.Gender,Gender);
        contentValues.put(MyDbhelper.City,City);
        long insert= sqLiteDatabase.insert(MyDbhelper.Table_name,null,contentValues);
        return insert;


    }

    public String login(String Username,String Password){

        SQLiteDatabase sqLiteDatabase=myDbhelper.getWritableDatabase();
        String [] clname={MyDbhelper.Name,MyDbhelper.Dob,MyDbhelper.Gender,MyDbhelper.Email,MyDbhelper.City};//Select name,dob,gender,city
        String where =MyDbhelper.Email +"=? and "+ MyDbhelper.Password +"=?"; //where
        String [] selection={Username,Password};

        Cursor cursor= sqLiteDatabase.query(MyDbhelper.Table_name,clname,where,selection,null,null,null);
        StringBuffer stringBuffer=new StringBuffer();
        if(cursor.moveToNext()){
            String Name=cursor.getString(cursor.getColumnIndex(MyDbhelper.Name));
            String Dob =cursor.getString(cursor.getColumnIndex(MyDbhelper.Dob));
            String Gender = cursor.getString(cursor.getColumnIndex(MyDbhelper.Gender));
            String Email = cursor.getString(cursor.getColumnIndex(MyDbhelper.Email));
            String City =cursor.getString(cursor.getColumnIndex(MyDbhelper.City));


            //stringBuffer.append("Sucessfully login , UserId" + Email + "and pass no is " + password+"and city is"+city);
            stringBuffer.append("Sucessfully Login");

        }
        else {
            stringBuffer.append("Wrong Username or Password");
        }
        String log = stringBuffer.toString();
        return log;

    }

    public class MyDbhelper extends SQLiteOpenHelper {

        //DATABASE CONTENT
        private static final String Database_name = "Registration";
        private static final int Version = 1;
        private static final String Table_name = "UserInfo";
        private static final String ID = "_id";
        private static final String Name = "Name";
        private static final String Dob = "Dob";
        private static final String Mobile_no = "Mobile_no";
        private static final String Email = "Email";
        private static final String Password = "Password";
        private static final String Gender = "Gender";
        private static final String City = "City";
        private static final String create_table = "CREATE TABLE " + Table_name + "(" + ID + " integer primary key autoincrement," + Name + " varchar(30)," + Dob + " varchar(20)," + Mobile_no + " varchar(15)," + Email + " varchar(30)," + Password + " varchar(30)," + Gender + " varchar(10)," + City + " varchar(20));";
        Context context;


        public MyDbhelper(Context context) {
            super(context, Database_name, null, Version);

            this.context = context;


        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(create_table);
            Toast.makeText(context, "Created", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}

