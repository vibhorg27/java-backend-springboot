package com.springframework.employeepayroll.service;

import com.springframework.employeepayroll.model.EmployeePayrollData;
import com.springframework.employeepayroll.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository repository;

    public EmployeePayrollData saveEmployees(EmployeePayrollData employee){
        return repository.save(employee);
    }

    public List<EmployeePayrollData> getAllEmployees(){
        return repository.findAll();
    }

    //Optional class used to omit null pointer exception
    public Optional<EmployeePayrollData> getEmployeeById(int id){
        return repository.findById(id);
    }

    public void deleteEmployeeById(int id){
        repository.deleteById(id);

    }
}
