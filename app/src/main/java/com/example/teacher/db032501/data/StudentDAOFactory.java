package com.example.teacher.db032501.data;

import android.content.Context;

/**
 * Created by teacher on 2017/4/1.
 */

public class StudentDAOFactory {
    public static StudentDAO getInstance(Context context, DAOType daoType)
    {
        switch(daoType)
        {
            case MEMORY:
                return new StudentDAOMemoryImpl();
            case FILE:
                return new StudentDAOFileImpl(context);
            case DATABASE:
                return new StudentDAODBImpl(context);
        }
        return null;
    }
}
