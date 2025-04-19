package com.springframework.employeepayroll.controller;


import com.springframework.employeepayroll.model.EmployeePayrollData;
import com.springframework.employeepayroll.repository.EmployeePayrollRepository;
import com.springframework.employeepayroll.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService service;

    @PostMapping("/create")
    public EmployeePayrollData createEmployee(@RequestBody EmployeePayrollData employee){
        return service.saveEmployees(employee);
    }

    @GetMapping("/get")
    public List<EmployeePayrollData> getAllEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public Optional<EmployeePayrollData> getEmployeeById(@PathVariable int id){
        return service.getEmployeeById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        service.deleteEmployeeById(id);
        return "Deleted " + id + " successfully";
    }
}
