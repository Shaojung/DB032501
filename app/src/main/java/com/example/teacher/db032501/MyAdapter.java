package com.example.teacher.db032501;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
    public boolean chks[];
    public MyAdapter(Context context, ArrayList<Student> stu)
    {
        this.context= context;
        students = stu;
        chks = new boolean[students.size()];
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
        chk.setChecked(chks[position]);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chks[position] = isChecked;
            }
        });
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

        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("確認刪除?");

                builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity m = (MainActivity) context;
                        m.impl.remove(students.get(position));
                        m.adapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();
                return true;
            }
        });

        return v;
    }
}
