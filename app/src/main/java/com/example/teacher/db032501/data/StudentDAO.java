package com.example.teacher.db032501.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teacher on 2017/3/25.
 */

public interface StudentDAO {
    public void add(Student s);
    public void update(Student s);
    public void remove(Student s);
    public void remove(List<Student> lst);
    public Student getStudent(int ID);
    public ArrayList<Student> getAllStudents();
    public void clearAll();
}
