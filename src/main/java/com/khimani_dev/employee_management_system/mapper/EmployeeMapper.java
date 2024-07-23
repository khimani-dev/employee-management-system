package com.khimani_dev.employee_management_system.mapper;

import com.khimani_dev.employee_management_system.dto.EmployeeDto;
import com.khimani_dev.employee_management_system.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
           return new EmployeeDto(
                   employee.getId(),
                   employee.getFirstName(),
                   employee.getLastName(),
                   employee.getEmail()
           );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto) { //converts employeeDto to employee Jpa Entity
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
