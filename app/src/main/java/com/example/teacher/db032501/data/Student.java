package com.example.teacher.db032501.data;

/**
 * Created by teacher on 2017/3/25.
 */

public class Student {
    public int ID;
    public String Name;
    public String Tel;
    public String Addr;

    public Student(int ID, String Name, String Tel, String Addr)
    {
        this.ID = ID;
        this.Name = Name;
        this.Tel = Tel;
        this.Addr = Addr;
    }
    @Override
    public String toString()
    {
        return "" + this.ID + "," + this.Name + "," + this.Tel + "," + this.Addr;
    }

}
