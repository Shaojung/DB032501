package com.example.teacher.db032501.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by teacher on 2017/4/8.
 */

public class MyHelper extends SQLiteOpenHelper {
    final static int version = 1;
    final static String dbname = "student.sqlite";
    public MyHelper(Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"phone\" (\"ID\" INTEGER PRIMARY KEY  NOT NULL , \"Name\" CHAR, \"Tel\" CHAR, \"Addr\" CHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
