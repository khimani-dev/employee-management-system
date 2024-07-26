package com.khimani_dev.employee_management_system.service.Impl;

import com.khimani_dev.employee_management_system.dto.EmployeeDto;
import com.khimani_dev.employee_management_system.entity.Employee;
import com.khimani_dev.employee_management_system.exception.ResourceNotFoundException;
import com.khimani_dev.employee_management_system.mapper.EmployeeMapper;
import com.khimani_dev.employee_management_system.repository.EmployeeRepository;
import com.khimani_dev.employee_management_system.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("employee does not exist with the given Id " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
       Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("employee does not exist with the given Id " + employeeId));

       //below 3 code lines set the updated employee details from updateEmployee object to Employee variable
       employee.setFirstName(updateEmployee.getFirstName());
       employee.setFirstName(updateEmployee.getLastName());
       employee.setEmail(updateEmployee.getEmail());

       Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj); //converts the updatedEmployeeObj from an JPA entity to a EmployeeDto
    }

    @Override
    public void deleteEmployee(Long employeeId) {
     Employee employee = employeeRepository.findById(employeeId)
             .orElseThrow(()->new ResourceNotFoundException("Employee does not exist using that Id" + employeeId));
     employeeRepository.deleteById(employeeId);
    }
}
