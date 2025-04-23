package com.example.EmployeePayrollDTO.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmployeePayrollDTO {

    @NotBlank(message = "Employee name is required")
    @Size(min = 2, message = "Name must have at least 2 characters")
    private String name;


    @NotNull(message = "Salary is required")
    @Min(value = 1000, message = "Salary must be at least 1000")
    private String salary;
}
