package com.srikanthpuram.samples.roomdatabaseapp;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import db.EmployeeDatabase;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static EmployeeDatabase employeeDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        employeeDatabase = Room.databaseBuilder(getApplicationContext(),EmployeeDatabase.class,"employees.db").allowMainThreadQueries().build();

        if(findViewById(R.id.fragment_container) != null) {
            if(savedInstanceState != null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container,new HomeFragment()).commit();
        }
    }
}
