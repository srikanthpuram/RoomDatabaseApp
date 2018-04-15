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
public class DeleteEmployeeFragment extends Fragment implements View.OnClickListener{

    private EditText employeeIdEditText;
    private Button deleteButton;

    public DeleteEmployeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_delete_employee, container, false);
        employeeIdEditText = view.findViewById(R.id.delete_employee_id_edit);
        deleteButton = view.findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        int employeId =  Integer.parseInt(employeeIdEditText.getText().toString());

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmployeeId(employeId);

        MainActivity.employeeDatabase.employeeDao().deleteEmployee(employeeEntity);

        Toast.makeText(getContext(),"Employee "+employeId+" deleted successfully", Toast.LENGTH_LONG).show();
    }
}
