package com.srikanthpuram.samples.roomdatabaseapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import db.EmployeeEntity;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddEmployeeFragment extends Fragment implements View.OnClickListener{

    private EditText employeeIdEditText, employeeNameEditText, employeeDesignationEditText;
    private Button addEmployeeButton;

    public AddEmployeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_employee, container, false);

        employeeIdEditText = view.findViewById(R.id.add_employee_id_edit);
        employeeNameEditText = view.findViewById(R.id.add_employee_name_edit);
        employeeDesignationEditText = view.findViewById(R.id.add_employee_designation_edit);

        addEmployeeButton = view.findViewById(R.id.employee_add_button);
        addEmployeeButton.setOnClickListener(this);
        return view;
    }

    public void addNewEmployee() {
        Log.d("AddEmployee", "Add Employee Button Clicked");
        int employeId = Integer.parseInt(employeeIdEditText.getText().toString());
        String employeName = employeeNameEditText.getText().toString();
        String employeDesignation = employeeDesignationEditText.getText().toString();

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmployeeId(employeId);
        employeeEntity.setEmployeeName(employeName);
        employeeEntity.setEmployeeDesignation(employeDesignation);

        MainActivity.employeeDatabase.employeeDao().addEmployee(employeeEntity);
        Toast.makeText(getContext(),"Employee added", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        addNewEmployee();
    }
}
