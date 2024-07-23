package com.khimani_dev.employee_management_system.service.Impl;

import com.khimani_dev.employee_management_system.dto.EmployeeDto;
import com.khimani_dev.employee_management_system.entity.Employee;
import com.khimani_dev.employee_management_system.mapper.EmployeeMapper;
import com.khimani_dev.employee_management_system.repository.EmployeeRepository;
import com.khimani_dev.employee_management_system.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor //creates the constructor for the injected repository class
public class EmployeeServiceImpl implements EmployeeService {

 private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);//the employeeMapper call has converted the employeeDto to Employee JPA entity
        Employee savedEmployee = employeeRepository.save(employee);//after = the method saves the already converted JPA entity into db
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);//converts the local variable savedEmployee from the Employee entity to employeeDto
    }
}
