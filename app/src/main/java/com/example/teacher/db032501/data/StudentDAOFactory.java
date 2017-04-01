package com.example.teacher.db032501.data;

/**
 * Created by teacher on 2017/4/1.
 */

public class StudentDAOFactory {
    public static StudentDAO getInstance(DAOType daoType)
    {
        switch(daoType)
        {
            case MEMORY:
                return new StudentDAOMemoryImpl();
            case FILE:
                return new StudentDAOFileImpl();
        }
        return null;
    }
}
