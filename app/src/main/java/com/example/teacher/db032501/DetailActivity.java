package com.example.teacher.db032501;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.teacher.db032501.data.Student;
import com.example.teacher.db032501.data.StudentDAOMemoryImpl;

public class DetailActivity extends AppCompatActivity {
    TextView tv1;
    EditText edName, edAddr, edTel;
    Student student;
    StudentDAOMemoryImpl impl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        int ID = getIntent().getIntExtra("ID", 0);
        impl = new StudentDAOMemoryImpl();
        student = impl.getStudent(ID);
        tv1 = (TextView) findViewById(R.id.tvDetailID);
        edName = (EditText) findViewById(R.id.edName);
        edAddr = (EditText) findViewById(R.id.edAddr);
        edTel = (EditText) findViewById(R.id.edTel);

        tv1.setText(String.valueOf(student.ID));
        edName.setText(student.Name);
        edAddr.setText(student.Addr);
        edTel.setText(student.Tel);

    }
    public void clickUpdate(View v)
    {
        student.Name = edName.getText().toString();
        student.Addr = edAddr.getText().toString();
        student.Tel = edTel.getText().toString();
        impl.update(student);
        finish();
    }
}
