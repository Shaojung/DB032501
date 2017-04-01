package com.example.teacher.db032501;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.teacher.db032501.data.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by teacher on 2017/4/1.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<Student> students;
    Context context;
    public MyAdapter(Context context, ArrayList<Student> stu)
    {
        this.context = context;
        students = stu;
    }
    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.myitem, null);
        TextView tv = (TextView) v.findViewById(R.id.textView);
        CheckBox chk = (CheckBox) v.findViewById(R.id.checkBox);
        tv.setText(students.get(position).Name);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, DetailActivity.class);
                it.putExtra("ID", students.get(position).ID);
                context.startActivity(it);
            }
        });
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, DetailActivity.class);
                it.putExtra("ID", students.get(position).ID);
                context.startActivity(it);
            }
        });
        return v;
    }
}
