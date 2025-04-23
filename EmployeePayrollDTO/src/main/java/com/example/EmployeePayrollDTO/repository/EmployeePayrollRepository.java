package com.example.EmployeePayrollDTO.repository;


import com.example.EmployeePayrollDTO.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {

    @Query("Select e from EmployeePayrollData e where e.department = :department and e.salary = :salary")
    List<EmployeePayrollData> findByDepartmentAndSalary(@Param("department") String department, @Param("salary") String salary);
}
