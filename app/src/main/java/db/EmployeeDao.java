package db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by spuram on 4/14/2018.
 */
@Dao
public interface EmployeeDao {

    @Insert
    public void addEmployee(EmployeeEntity employeeEntity);

    @Update
    public void updateEmployee(EmployeeEntity employeeEntity);

    @Delete
    public void deleteEmployee(EmployeeEntity employeeEntity);

    @Query("select * from Employees")
    public List<EmployeeEntity> showEmployees();
}
