package db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by spuram on 4/14/2018.
 */
@Database(entities = {EmployeeEntity.class}, version = 1)
public abstract class EmployeeDatabase extends RoomDatabase{

    //return an instance of EmployeeDao
    public abstract EmployeeDao employeeDao();
}
