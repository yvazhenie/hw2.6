package com.makarov.homework26.serivce;

import com.makarov.homework26.model.Employee;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);


    Employee [] getAllEmployees();

}
