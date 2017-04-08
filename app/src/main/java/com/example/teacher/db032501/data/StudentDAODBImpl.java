package com.example.teacher.db032501.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

    }

    @Override
    public void update(Student s) {

    }

    @Override
    public void remove(Student s) {

    }

    @Override
    public void remove(List<Student> lst) {

    }

    @Override
    public Student getStudent(int ID) {
        return null;
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        return null;
    }

    @Override
    public void clearAll() {

    }
}
