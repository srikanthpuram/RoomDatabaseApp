package com.srikanthpuram.samples.roomdatabaseapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button addEmployeeButton;
    private Button showEmployeesButton;
    private Button updateEmployeeButton;
    private Button deleteEmployeeButton;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_home, container, false);
        addEmployeeButton = view.findViewById(R.id.add_employee_btn);
        addEmployeeButton.setOnClickListener(this);
        showEmployeesButton = view.findViewById(R.id.show_employees_btn);
        showEmployeesButton.setOnClickListener(this);
        updateEmployeeButton = view.findViewById(R.id.update_employee_btn);
        updateEmployeeButton.setOnClickListener(this);
        deleteEmployeeButton = view.findViewById(R.id.delete_employee_btn);
        deleteEmployeeButton.setOnClickListener(this);
        return view;
    }

    public void addEmployee() {
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new AddEmployeeFragment()).
                addToBackStack(null).commit();
    }

    public void showEmployees() {
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ShowEmployeesFragment()).
                addToBackStack(null).commit();
    }

    public void updateEmployee() {
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new UpdateEmployeeFragment()).
                addToBackStack(null).commit();
    }

    public void deleteEmployee() {
        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteEmployeeFragment()).
                addToBackStack(null).commit();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.add_employee_btn){
            addEmployee();
        }else if(view.getId()== R.id.show_employees_btn){
            showEmployees();
        }else if(view.getId()== R.id.update_employee_btn){
            updateEmployee();
        }else if(view.getId()== R.id.delete_employee_btn){
            deleteEmployee();
        }
    }
}
