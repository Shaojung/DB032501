package com.example.teacher.db032501.data;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
            String dataStr = br.readLine();
            data.clear();
            Gson gson = new Gson();
            data = gson.fromJson(dataStr, new TypeToken<List<Student>>(){}.getType());
            br.close();
        } catch (FileNotFoundException e) {
            data = new ArrayList<>();
            e.printStackTrace();
        } catch (IOException e) {
            data = new ArrayList<>();
            e.printStackTrace();
        }
    }

    private void saveFile()
    {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(dataFile));
            Gson gson = new Gson();
            String dataStr = gson.toJson(data);
            bw.write(dataStr);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    @Override
    public void add(Student s) {
        data.add(s);
        saveFile();
    }

    @Override
    public void update(Student s) {
        for (Student d : data)
        {
            if (d.ID == s.ID)
            {
                d.Name = s.Name;
                d.Tel = s.Tel;
                d.Addr = s.Addr;
            }
        }
        saveFile();
    }

    @Override
    public void remove(Student s) {
        int i;
        for (i=data.size()-1;i>=0;i--)
        {
            if (data.get(i).ID == s.ID)
            {
                data.remove(i);
            }
        }
        saveFile();
    }

    @Override
    public void remove(List<Student> lst) {
        int i;
        for (i=data.size()-1;i>=0;i--)
        {
            for (Student s : lst) {
                if (data.get(i).ID == s.ID)
                {
                    data.remove(i);
                    break;
                }
            }
        }
        saveFile();
    }

    @Override
    public Student getStudent(int ID) {
        for (Student d : data)
        {
            if (d.ID == ID)
            {
                return d;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        return data;
    }

    @Override
    public void clearAll() {
        data.clear();
        saveFile();
    }
}
