package com.example.crud_task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class sqlhelper extends SQLiteOpenHelper {
    public static final String db_name="daniyalDB.db";
    public static final String Table_name="Task_crud";
    public static final String col_1="Id";
    public static final String col_2="Name";
    public static final String col_3="Gender";
    public static final String col_4="City";
    public static final String col_5="Places";

    public sqlhelper(Context context)
    {
        super(context,db_name,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table "+Table_name+"(Id INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT,Gender TEXT,City TEXT,Places TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE IF EXISTS "+Table_name);
    }

    public boolean insertdata(String Name,String Gender,String City,String Places)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_2,Name);
        contentValues.put(col_3,Gender);
        contentValues.put(col_4,City);
        contentValues.put(col_5,Places);

        long res=db.insert(Table_name,null,contentValues);
        if (res==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor getalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+Table_name,null);
        return res;

    }
    public boolean updatedate(String Id,String Name,String Gender,String City,String Places)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_1,Id);
        contentValues.put(col_2,Name);
        contentValues.put(col_3,Gender);
        contentValues.put(col_4,City);
        contentValues.put(col_5,Places);

        long res=db.update(Table_name,contentValues,"Id=?",new String[]{Id});
        return true;
        /*if (res == -1)
        {
            return false;
        }
        else
        {
            return true;
        }*/
    }
    public Integer deletedata(String Id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(Table_name,"Id=?",new String[]{Id});
    }
    /*public ArrayList<crud_class> readCourses() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + Table_name, null);

        // on below line we are creating a new array list.
        ArrayList<crud_class> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new crud_class(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }*/
}
