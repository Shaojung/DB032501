package com.example.teacher.db032501.data;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by teacher on 2017/4/1.
 */

public class StudentDAOFileImpl implements StudentDAO {
    public static ArrayList<Student> data = new ArrayList<>();
    private File dataFile;
    Context context;
    public StudentDAOFileImpl(Context context)
    {
        this.context = context;
        File fileDir = context.getFilesDir();
        dataFile = new File(fileDir.toString() + File.separator + "mydata.json");
        loadFile();
    }

    private void loadFile()
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(dataFile));
            String data = br.readLine();
            Log.d("MYDATA", data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
