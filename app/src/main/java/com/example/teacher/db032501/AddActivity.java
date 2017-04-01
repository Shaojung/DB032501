package com.example.teacher.db032501;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.teacher.db032501.data.Student;
import com.example.teacher.db032501.data.StudentDAOMemoryImpl;

public class AddActivity extends AppCompatActivity {
    EditText ed, ed2, ed3, ed4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ed = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);
        ed4 = (EditText) findViewById(R.id.editText4);

    }
    public void clickAdd(View v)
    {
        StudentDAOMemoryImpl impl = new StudentDAOMemoryImpl();
        int no = Integer.valueOf(ed.getText().toString());
        String n = ed2.getText().toString();
        String t = ed3.getText().toString();
        String a = ed4.getText().toString();
        impl.add(new Student(no, n, t, a));
        finish();
    }
}
