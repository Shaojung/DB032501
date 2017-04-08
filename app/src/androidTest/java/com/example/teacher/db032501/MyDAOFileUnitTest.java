package com.example.teacher.db032501;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.teacher.db032501.data.DAOType;
import com.example.teacher.db032501.data.Student;
import com.example.teacher.db032501.data.StudentDAO;
import com.example.teacher.db032501.data.StudentDAOFactory;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by teacher on 2017/4/8.
 */

@RunWith(AndroidJUnit4.class)
public class MyDAOFileUnitTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.teacher.db032501", appContext.getPackageName());
    }

    @Test
    public void addTwoData() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        StudentDAO dao = StudentDAOFactory.getInstance(appContext, DAOType.FILE);
        dao.clearAll();
        dao.add(new Student(1, "AA", "11AA", "AA11111"));
        dao.add(new Student(2, "BB", "22BB", "BB11111"));
        assertEquals(dao.getAllStudents().size(), 2);
    }

    @Test
    public void testRemove() throws Exception
    {
        Context appContext = InstrumentationRegistry.getTargetContext();
        StudentDAO dao = StudentDAOFactory.getInstance(appContext, DAOType.FILE);
        dao.clearAll();
        dao.add(new Student(1, "AA", "123123", "AABB"));
        dao.add(new Student(2, "BB", "123123", "AABB"));
        dao.add(new Student(3, "CC", "123123", "AABB"));
        Student newdata = new Student(1, "AA", "123123", "AABB");
        dao.remove(newdata);

        for (Student s : dao.getAllStudents())
        {
            System.out.println("test delete:" +  s.toString());
        }
        assertEquals(dao.getAllStudents().size(), 2);
    }
}
