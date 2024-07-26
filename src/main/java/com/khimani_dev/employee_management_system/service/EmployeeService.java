package com.khimani_dev.employee_management_system.service;

import com.khimani_dev.employee_management_system.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto>getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId,EmployeeDto updateEmployee);

    void deleteEmployee(Long employeeId);
}
