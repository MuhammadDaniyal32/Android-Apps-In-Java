package com.example.image_crud;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLHelper extends SQLiteOpenHelper {

    public SQLHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version)
    {
        super(context, name, factory, version);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table FOOD (id Interger primary key autoincrement,name Text,price Text,image byte)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("Drop Table IF Exists FOOD");
        onCreate(db);

    }
    public void  INSERTDATA(String name,String price,byte[] image)
    {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO FOOD VALUES (NULL, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindBlob(3, image);
        statement.executeInsert();

    }
    public void UPDATEDATA(String name,String price,byte[] image,int id)
    {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE FOOD SET name = ?, price = ?, image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindBlob(3, image);
        statement.bindDouble(4, (double)id);

        statement.execute();
        database.close();
    }
    public void DELETEDATA(int id)
    {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM FOOD WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }
    public Cursor GETDATA(String sql)
    {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }
    public void  QUERYDATA(String sql)
    {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
}
