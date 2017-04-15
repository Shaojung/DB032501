package com.example.teacher.db032501.data;

import android.content.Context;
import android.util.Log;

import com.example.teacher.db032501.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by teacher on 2017/4/1.
 */

public class StudentDAOCloudImpl implements StudentDAO {
    public static ArrayList<Student> data = new ArrayList<>();
    Context context;
    public StudentDAOCloudImpl(Context context)
    {
        this.context = context;
        loadFile();
    }

    private void loadFile()
    {

        // Read from the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("phone");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                // Log.d(TAG, "Value is: " + value);
                data.clear();
                Gson gson = new Gson();
                data = gson.fromJson(value, new TypeToken<List<Student>>(){}.getType());
                if (data == null)
                {
                    data = new ArrayList<Student>();
                }
                ((MainActivity) context).list = getAllStudents();
                Log.d("MYDB", "List size:" + ((MainActivity) context).list.size());
                ((MainActivity) context).adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void saveFile()
    {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("phone");
        Gson gson = new Gson();
        String dataStr = gson.toJson(data);
        myRef.setValue(dataStr);

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
