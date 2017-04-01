package com.example.teacher.db032501;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.teacher.db032501.data.Student;
import com.example.teacher.db032501.data.StudentDAOMemoryImpl;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        int ID = getIntent().getIntExtra("ID", 0);
        StudentDAOMemoryImpl impl = new StudentDAOMemoryImpl();
        Student student = impl.getStudent(ID);


    }
}
