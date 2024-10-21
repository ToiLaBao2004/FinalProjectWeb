package com.mobileshopweb.service;

import com.mobileshopweb.dto.request.EmployeeCreationRequest;
import com.mobileshopweb.dto.request.EmployeeUpdateRequest;
import com.mobileshopweb.entity.Employee;
import com.mobileshopweb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(EmployeeCreationRequest employeeCreationRequest) {
        Employee employee = new Employee();

        employee.setEmployeeID(employeeCreationRequest.getEmployeeID());
        employee.setNameEmployee(employeeCreationRequest.getNameEmployee());
        employee.setBirthday(employeeCreationRequest.getBirthday());
        employee.setGender(employeeCreationRequest.getGender());
        employee.setAddressEmployee(employeeCreationRequest.getAddressEmployee());
        employee.setPhoneNumber(employeeCreationRequest.getPhoneNumber());
        employee.setRoleEmployee(employeeCreationRequest.getRoleEmployee());
        employee.setActive(employeeCreationRequest.getActive());
        employee.setPassWordAccount(employeeCreationRequest.getPassWordAccount());

        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String Id) {
        return employeeRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Employee updateEmployee(String Id, EmployeeUpdateRequest employeeUpdateRequest) {
        Employee employee = getEmployeeById(Id);

        employee.setNameEmployee(employeeUpdateRequest.getNameEmployee());
        employee.setBirthday(employeeUpdateRequest.getBirthday());
        employee.setGender(employeeUpdateRequest.getGender());
        employee.setAddressEmployee(employeeUpdateRequest.getAddressEmployee());
        employee.setPhoneNumber(employeeUpdateRequest.getPhoneNumber());
        employee.setRoleEmployee(employeeUpdateRequest.getRoleEmployee());
        employee.setActive(employeeUpdateRequest.getActive());
        employee.setPassWordAccount(employeeUpdateRequest.getPassWordAccount());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(String Id) {
        employeeRepository.deleteById(Id);
    }
}
