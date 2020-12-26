package com.example.divyashreesoni.practice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "customer.db";
    public static final String TABLE_NAME = "user";
    public static final String col_1 = "ID";
    public static final String col_2 = "NAME";
    public static final String col_3 = "PASSWORD";
    public static final String col_4 = "EMAIL";
    public static final String col_5 = "CONTACT";


    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(" create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PASSWORD TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);
    }

    public boolean insertData(String username, String password, String email, String contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2, username);
        contentValues.put(col_3, password);
        contentValues.put(col_4, email);
        contentValues.put(col_5, contact);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean checkUsername(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where name=?", new String[]{name});
        if(cursor.getCount() > 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean check(String name, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from  user  where name=? and password=?", new String[]{name, password});
        if(c.getCount() > 0)
            return true;
        else
            return false;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}
