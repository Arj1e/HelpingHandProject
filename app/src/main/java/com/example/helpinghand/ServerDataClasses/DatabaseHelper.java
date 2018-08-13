package com.example.helpinghand.ServerDataClasses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "HelpingHandDb";
    public static final String TABLE_NAME = "User_tb";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "LOGIN";
    public static final String COL_3 = "PASSWORD";
    public static final String COL_4 = "NAME";
    public static final String COL_5 = "LASTNAME";
    public static final String COL_6 = "POINTS";
    public static final String COL_7 = "LATITUDE";
    public static final String COL_8 = "LONGTITUDE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(ID TEXT,LOGIN TEXT,PASSWORD TEXT,NAME TEXT,LASTNAME TEXT, POINTS INTEGER, LATITUDE DOUBLE, LONGTITUDE DOUBLE )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public  boolean insertData(String id,String login,String password, String name,String lastname, int points, Double latitude, Double longtitude ) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valuesToPut = new ContentValues();
        valuesToPut.put(COL_1, id);
        valuesToPut.put(COL_2, login);
        valuesToPut.put(COL_3, password);
        valuesToPut.put(COL_4, name);
        valuesToPut.put(COL_5, lastname);
        valuesToPut.put(COL_6, points);
        valuesToPut.put(COL_7, latitude);
        valuesToPut.put(COL_8, longtitude);
        long result = db.insert(TABLE_NAME, null, valuesToPut);
        if (result == -1){
            return false;
         }else{
            return true;
            }
    }
    public Cursor getData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor getNameById = db.rawQuery("select NAME from "+TABLE_NAME+" Where ID= "+id,null);
        return  getNameById;

    }
}
