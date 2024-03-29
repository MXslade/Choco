package com.example.rahmetex1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "booksDB";
    public static final String TABLE_BOOKS = "books";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PAGESCOUNT = "pagesCount";
    public static final String KEY_PRICE = "price";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_BOOKS + "(" + KEY_ID + " integer primary key," +
                    KEY_NAME + " text," + KEY_PAGESCOUNT + " integer," + KEY_PRICE + " integer" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_BOOKS);

        onCreate(db);
    }
}
