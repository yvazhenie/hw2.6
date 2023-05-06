package com.makarov.homework26.controller;

import com.makarov.homework26.model.Employee;
import com.makarov.homework26.serivce.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
@GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,@RequestParam String lastName) {
    return employeeService.addEmployee(firstName, lastName);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,@RequestParam String lastName) {
return employeeService.removeEmployee(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,@RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }
    @GetMapping()
    public Employee[] getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
