package com.example.login_registration_with_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "login.db";
    public dbhelper(Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE user(ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, Email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST user");
    }
    public boolean Insert(String username, String password,String email){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("email", email);
        long result = sqLiteDatabase.insert("user", null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean CheckUsername(String username){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE username=?", new String[]{username});
        if(cursor.getCount() > 0){
            return false;
        }else{
            return true;
        }
    }

    public Boolean CheckLogin(String username, String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE username=? AND password=?", new String[]{username, password});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }
//    public Cursor getdata(String username, String password){
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE username=? AND password=?", new String[]{username, password});
//        return cursor;
//    }
}

