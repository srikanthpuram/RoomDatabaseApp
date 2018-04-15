package com.srikanthpuram.samples.roomdatabaseapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import db.EmployeeEntity;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowEmployeesFragment extends Fragment {

    private TextView showEmployeesTextView;

    public ShowEmployeesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_show_employees, container, false);
        showEmployeesTextView = view.findViewById(R.id.show_employees_tv);

        List<EmployeeEntity> employeesList = MainActivity.employeeDatabase.employeeDao().showEmployees();

        String employeesInfo = "";
        for(EmployeeEntity employeeInfo : employeesList) {
            int employeeId = employeeInfo.getEmployeeId();
            String employeeName = employeeInfo.getEmployeeName();
            String employeeDesignation = employeeInfo.getEmployeeDesignation();

            employeesInfo = employeesInfo+"\n\n"+"Empl Id: "+employeeId+"\n Name: "+employeeName+"\n Designation: "+employeeDesignation;
            showEmployeesTextView.setText(employeesInfo);
        }
        return view;
    }

}
