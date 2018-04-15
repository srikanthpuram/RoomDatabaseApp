package com.srikanthpuram.samples.roomdatabaseapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class UpdateEmployeeFragment extends Fragment implements View.OnClickListener{

    private EditText employeIdEditText,employeNameEditText,employeDesignationEditText;
    private Button updateEmployeeButton;
    public UpdateEmployeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_employee, container, false);
        employeIdEditText = view.findViewById(R.id.update_employee_id_edit);
        employeNameEditText = view.findViewById(R.id.update_employee_name_edit);
        employeDesignationEditText = view.findViewById(R.id.update_employee_designation_edit);
        updateEmployeeButton = view.findViewById(R.id.update_button);

        updateEmployeeButton.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View view) {
        int employeeId = Integer.parseInt(employeIdEditText.getText().toString());
        String employeeName = employeNameEditText.getText().toString();
        String employeeDesignation = employeDesignationEditText.getText().toString();

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmployeeId(employeeId);
        employeeEntity.setEmployeeName(employeeName);
        employeeEntity.setEmployeeDesignation(employeeDesignation);

        MainActivity.employeeDatabase.employeeDao().updateEmployee(employeeEntity);

        Toast.makeText(getActivity(),"Employee: "+employeeId+" ,"+employeeName+" Updated Successfully",Toast.LENGTH_LONG).show();

    }
}
