package com.example.crud_in_android_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class db_helper extends SQLiteOpenHelper {
public static final String Database_name="daniyal_crud.db";
public static final String Table_name="Crud_table";
    public static final String col_1="ID";
    public static final String col_2="NAME";
    public static final String col_3="GENDER";
    public static final String col_4="ROLLNO";

    public db_helper(Context context) {
        super(context,Database_name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+Table_name+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, GENDER TEXT, ROLLNO INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_name);
        onCreate(db);
    }
    public boolean insertData(String NAME, String GENDER, String ROLLNO)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,NAME);
        contentValues.put(col_3,GENDER);
        contentValues.put(col_4,ROLLNO);
        long result = db.insert(Table_name,null, contentValues);

        if(result == -1)
        {
            return false;
        }
        else
        {
            return  true;
        }

    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+Table_name,null);
        return  res;
    }

    public boolean updateData(String ID,String NAME,String GENDER,String ROLLNO) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,ID);
        contentValues.put(col_2,NAME);
        contentValues.put(col_3,GENDER);
        contentValues.put(col_4,ROLLNO);
        db.update(Table_name, contentValues, "ID = ?",new String[] { ID });
        return true;
    }

    public Integer deleteData (String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Table_name, "ID = ?",new String[] {ID});
    }
}
