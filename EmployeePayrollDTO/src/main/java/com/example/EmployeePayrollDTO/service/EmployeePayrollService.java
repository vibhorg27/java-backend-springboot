package com.example.EmployeePayrollDTO.service;

import com.example.EmployeePayrollDTO.model.EmployeePayrollDTO;
import com.example.EmployeePayrollDTO.model.EmployeePayrollData;
import com.example.EmployeePayrollDTO.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository repository;

    public EmployeePayrollData saveEmployees(EmployeePayrollDTO employeeDTO){
        EmployeePayrollData employee = new EmployeePayrollData();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        return repository.save(employee);
    }

    public List<EmployeePayrollData> getAllEmployees(){
        return repository.findAll();
    }

    //Optional class used to omit null pointer exception as there can be an invalid id as well
    public Optional<EmployeePayrollData> getEmployeeById(int id){
        return repository.findById(id);
    }

    //Method to get employee by department and salary
    public List<EmployeePayrollData> getEmployeeByDepartmentAndSalary(String department, String salary){
        return repository.findByDepartmentAndSalary(department, salary);
    }

    public void deleteEmployeeById(int id){
        repository.deleteById(id);

    }
}
