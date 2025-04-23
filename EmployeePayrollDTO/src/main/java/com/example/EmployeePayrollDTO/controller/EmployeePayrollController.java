package com.example.EmployeePayrollDTO.controller;

import com.example.EmployeePayrollDTO.model.EmployeePayrollDTO;
import com.example.EmployeePayrollDTO.model.EmployeePayrollData;
import com.example.EmployeePayrollDTO.service.EmployeePayrollService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService service;

    @PostMapping("/create")
    public ResponseEntity<EmployeePayrollData> createEmployee(@Valid @RequestBody EmployeePayrollDTO employee){
        return ResponseEntity.ok(service.saveEmployees(employee));
    }

    @GetMapping("/get")
    public ResponseEntity<List<EmployeePayrollData>> getAllEmployees(){
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeePayrollData> getEmployeeById(@PathVariable int id){
        EmployeePayrollData result = service.getEmployeeById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/department/{department}/salary/{salary}")
    public ResponseEntity<List<EmployeePayrollData>> getEmployeeByDepartmentAndSalary(@PathVariable String department, @PathVariable String salary){
        return ResponseEntity.ok(service.getEmployeeByDepartmentAndSalary(department, salary));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int id){
        service.deleteEmployeeById(id);
        return ResponseEntity.ok("Deleted " + id + " successfully");
    }
}
