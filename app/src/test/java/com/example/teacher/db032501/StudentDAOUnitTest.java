package com.example.teacher.db032501;

import android.provider.ContactsContract;
import android.util.Log;

import com.example.teacher.db032501.data.Student;
import com.example.teacher.db032501.data.StudentDAOMemoryImpl;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by teacher on 2017/3/25.
 */

public class StudentDAOUnitTest {
    @Test
    public void testAdd() throws Exception
    {
        StudentDAOMemoryImpl impl = new StudentDAOMemoryImpl();
        impl.clearAll();
        impl.add(new Student(1, "AA", "123123", "AABB"));
        ArrayList<Student> list = impl.getAllStudents();
        for (Student s : list)
        {
            System.out.println(s.toString());
        }
        assertEquals(impl.getAllStudents().size(), 1);
    }
    @Test
    public void testAdd2() throws Exception
    {
        StudentDAOMemoryImpl impl = new StudentDAOMemoryImpl();
        impl.clearAll();
        impl.add(new Student(1, "AA", "123123", "AABB"));
        impl.add(new Student(2, "BB", "123123", "AABB"));
        ArrayList<Student> list = impl.getAllStudents();
        for (Student s : list)
        {
            System.out.println(s.toString());
        }
        assertEquals(impl.getAllStudents().size(), 2);
    }

    @Test
    public void testUpdate() throws Exception
    {
        StudentDAOMemoryImpl impl = new StudentDAOMemoryImpl();
        impl.clearAll();
        impl.add(new Student(1, "AA", "123123", "AABB"));
        impl.add(new Student(2, "BB", "123123", "AABB"));
        Student newdata = new Student(2, "CDE", "321321", "BBCC");
        impl.update(newdata);
        ArrayList<Student> list = impl.getAllStudents();
        for (Student s : list)
        {
            if (s.ID == 2)
            {
                System.out.println("test update:" + s.toString());
                assertEquals(s.Name, "CDE");
            }
        }

    }
    @Test
    public void testRemove() throws Exception
    {
        StudentDAOMemoryImpl impl = new StudentDAOMemoryImpl();
        impl.clearAll();
        impl.add(new Student(1, "AA", "123123", "AABB"));
        impl.add(new Student(2, "BB", "123123", "AABB"));
        impl.add(new Student(3, "CC", "123123", "AABB"));
        Student newdata = new Student(1, "AA", "123123", "AABB");
        impl.remove(newdata);

        for (Student s : impl.getAllStudents())
        {
            System.out.println("test delete:" +  s.toString());
        }
        assertEquals(impl.getAllStudents().size(), 2);
    }
    @Test
    public void testRemoveList() throws Exception
    {
        StudentDAOMemoryImpl impl = new StudentDAOMemoryImpl();
        impl.clearAll();
        impl.add(new Student(1, "AA", "123123", "AABB"));
        impl.add(new Student(2, "BB", "123123", "AABB"));
        impl.add(new Student(3, "CC", "123123", "AABB"));

        ArrayList<Student> lst = new ArrayList<>();
        lst.add(new Student(1, "AA", "123123", "AABB"));
        lst.add(new Student(3, "CC", "123123", "AABB"));

        impl.remove(lst);

        for (Student s : impl.getAllStudents())
        {
            System.out.println("list test delete:" +  s.toString());
        }
        assertEquals(impl.getAllStudents().size(), 1);
    }

    @Test
    public void testGetStudent() throws Exception
    {
        StudentDAOMemoryImpl impl = new StudentDAOMemoryImpl();
        impl.clearAll();
        impl.add(new Student(1, "AA", "123123", "AABB"));
        impl.add(new Student(2, "BB", "123123", "AABB"));
        impl.add(new Student(3, "CC", "123123", "AABB"));

        Student s = impl.getStudent(2);
        assertEquals(s.Name, "BB");
    }
}
