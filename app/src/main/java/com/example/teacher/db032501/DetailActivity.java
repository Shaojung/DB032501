package com.example.teacher.db032501;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.teacher.db032501.data.Student;
import com.example.teacher.db032501.data.StudentDAOMemoryImpl;

public class DetailActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        int ID = getIntent().getIntExtra("ID", 0);
        StudentDAOMemoryImpl impl = new StudentDAOMemoryImpl();
        Student student = impl.getStudent(ID);
        tv1 = (TextView) findViewById(R.id.tvDetailID);
        tv2 = (TextView) findViewById(R.id.tvDetailName);
        tv3 = (TextView) findViewById(R.id.tvDetailAddr);
        tv4 = (TextView) findViewById(R.id.tvDetailTel);
        tv1.setText(String.valueOf(student.ID));
        tv2.setText(student.Name);
        tv3.setText(student.Addr);
        tv4.setText(student.Tel);

    }
}
