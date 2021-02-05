package com.example.loginregpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.concurrent.Callable;


public class DBhelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "appssdc";
    public static final String DB_TABLE = "abc";
    public static final String col_0 = "id";
    public static final String col_3 = "name";
    public static final String col_1 = "password";
    public static final String col_2 = "email";
    public static final int DB_VERSION = 2;
    public static final String CREATE_QUERY = "create table " + DB_TABLE + "(" + col_3+ " integer primary key autoincrement," + col_0 + " text," + col_1 + " text," + col_2 + " text);";


    public DBhelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP table if exists " + DB_TABLE);
        onCreate(db);
    }

    public long saveData(ContentValues cn) {
        SQLiteDatabase db = getWritableDatabase();
        long row = db.insert(DB_TABLE, null, cn);
        return row;
    }

    public Cursor retriveData() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+DB_TABLE,null);
        return c;
    }
}
