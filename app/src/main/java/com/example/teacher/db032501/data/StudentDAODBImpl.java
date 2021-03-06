package com.example.teacher.db032501.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teacher on 2017/4/8.
 */

public class StudentDAODBImpl implements StudentDAO {
    Context context;
    SQLiteDatabase db;
    public StudentDAODBImpl(Context context)
    {
        this.context = context;
        MyHelper helper = new MyHelper(context);
        db = helper.getWritableDatabase();
    }
    @Override
    public void add(Student s) {
        ContentValues cv = new ContentValues();
        cv.put("ID", s.ID);
        cv.put("Name", s.Name);
        cv.put("Tel", s.Tel);
        cv.put("Addr", s.Addr);
        db.insert("phone", null, cv );
    }

    @Override
    public void update(Student s) {
        ContentValues cv = new ContentValues();
        cv.put("Name", s.Name);
        cv.put("Tel", s.Tel);
        cv.put("Addr", s.Addr);
        db.update("phone", cv, "ID=?", new String[]{String.valueOf(s.ID)});

    }

    @Override
    public void remove(Student s) {
        db.delete("phone", "ID=?", new String[]{String.valueOf(s.ID)});

    }

    @Override
    public void remove(List<Student> lst) {
        ArrayList<String> params = new ArrayList<>();
        for (Student s : lst)
        {
            params.add(String.valueOf(s.ID));
        }
        db.execSQL("Delete From phone Where ID in (" + TextUtils.join(",", params) + ");");
    }

    @Override
    public Student getStudent(int ID) {
        Cursor c = db.query("phone", new String[] {"ID", "Name", "Tel", "Addr"}, "ID=?", new String[] {String.valueOf(ID)}, null, null, null);
        c.moveToFirst();
        return new Student(c.getInt(0), c.getString(1), c.getString(2), c.getString(3));

        // Log.d("DB", "after return");
        // return null;
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> data = new ArrayList<>();
        Cursor c = db.query("phone", new String[] {"ID", "Name", "Tel", "Addr"}, null, null, null, null, null);
        if (c.moveToFirst())
        {
            do {
                data.add(new Student(c.getInt(0), c.getString(1), c.getString(2), c.getString(3)));
            }while (c.moveToNext());

        }
        return data;
    }

    @Override
    public void clearAll() {
        db.execSQL("Delete From phone");
    }
}
