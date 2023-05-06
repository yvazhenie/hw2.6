package com.makarov.homework26.serivce.impl;

import com.makarov.homework26.exception.EmployeeAlreadyAddedException;
import com.makarov.homework26.exception.EmployeeNotFoundException;
import com.makarov.homework26.exception.EmployeeStorageIsFullException;
import com.makarov.homework26.model.Employee;
import com.makarov.homework26.serivce.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Employee[] employees;
    public EmployeeServiceImpl() {
        employees = new Employee[0];
    }
    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        if(employee!=null){
            throw new EmployeeAlreadyAddedException();
        }
        employee = new Employee(firstName, lastName);
        for (int i = 0; i <employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return employee;
            }
            
        }
        throw new EmployeeStorageIsFullException();

    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        if(employee==null){
            throw new EmployeeNotFoundException();
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(employee)) {
                employees[i] = null;
            }
        }
        return employee;
    }





    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(employee)) {
                return employees[i];
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee[] getAllEmployees() {
        return employees;
    }
}
