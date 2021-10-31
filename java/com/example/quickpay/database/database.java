package com.example.quickpay.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class database extends SQLiteOpenHelper {

    public static final String dbname="sign_up_db";
    public database(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create="create table users(_id Integer primary key autoincrement,username text,password text)";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
        onCreate(sqLiteDatabase);
    }
    public boolean add_data(String username,String password){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("username",username);
        values.put("password",password);
        long r=db.insert("users",null,values);
        if(r==-1){
            return false;
        }else {
            return true;
        }
    }
    public  boolean check_data(String username,String password){
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users where username =? and password=?",new String[] {username,password});
        if(cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean update_data(String username,String password){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("password" , password);
        Cursor cursor=db.rawQuery("select * from users where username =? ",new String[] {username});
        if(cursor.getCount()>0){
            long r=db.update("users",values,"username =?",new String[] {username});
            if(r==-1){
                return false;
            }else {
                return true;
            }
        }else {
            return false;
        }
    }
}