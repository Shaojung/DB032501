package com.example.teacher.db032501;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.teacher.db032501.data.Student;
import com.example.teacher.db032501.data.StudentDAO;
import com.example.teacher.db032501.data.StudentDAOMemoryImpl;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> str = new ArrayList<>();
    ListView lv;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void refreshStr()
    {
        final StudentDAOMemoryImpl impl = new StudentDAOMemoryImpl();
        final ArrayList<Student> list = impl.getAllStudents();
        str.clear();
        int i;
        for (i=0;i<list.size();i++)
        {
            str.add(list.get(i).Name);
        }
        Log.d("STR", "Str Length:" + str.size());
    }

    @Override
    protected void onResume() {
        super.onResume();
        final StudentDAOMemoryImpl impl = new StudentDAOMemoryImpl();
        final ArrayList<Student> list = impl.getAllStudents();
        refreshStr();

        lv = (ListView) findViewById(R.id.listView);
        adapter = new MyAdapter(MainActivity.this, list);

        lv.setAdapter(adapter);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("確認刪除?");
                builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        impl.remove(list.get(position));
                        refreshStr();
                        adapter.notifyDataSetChanged();

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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuAdd)
        {
            startActivity(new Intent(MainActivity.this, AddActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
