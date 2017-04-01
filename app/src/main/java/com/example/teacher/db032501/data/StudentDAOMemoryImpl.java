package com.example.teacher.db032501.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teacher on 2017/3/25.
 */

public class StudentDAOMemoryImpl implements StudentDAO {
    public static ArrayList<Student> data = new ArrayList<>();;

    @Override
    public void clearAll()
    {
        data.clear();
    }

    @Override
    public void add(Student s) {
        data.add(s);
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
                }
            }
        }
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
}
