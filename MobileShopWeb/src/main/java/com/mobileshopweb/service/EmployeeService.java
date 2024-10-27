package com.mobileshopweb.service;

import com.mobileshopweb.dto.request.EmployeeCreationRequest;
import com.mobileshopweb.dto.request.EmployeeLoginRequest;
import com.mobileshopweb.dto.request.EmployeeUpdateRequest;
import com.mobileshopweb.entity.Employee;
import com.mobileshopweb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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
        employee.setPassWordAccount(passwordEncoder.encode(employeeCreationRequest.getPassWordAccount()));

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
        employee.setPassWordAccount(passwordEncoder.encode(employeeUpdateRequest.getPassWordAccount()));

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(String Id) {
        employeeRepository.deleteById(Id);
    }

    public Employee login(EmployeeLoginRequest employeeLoginRequest) {
        System.out.println("Employee ID: " + employeeLoginRequest.getEmployeeID());
        System.out.println("Password: " + employeeLoginRequest.getPassWordAccount());
        if (employeeLoginRequest.getEmployeeID() == null || employeeLoginRequest.getPassWordAccount() == null) {
            throw new RuntimeException("Employee ID and password must not be null");
        }

        Optional<Employee> employeeOpt = employeeRepository.findById(employeeLoginRequest.getEmployeeID());
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            if (passwordEncoder.matches(employeeLoginRequest.getPassWordAccount(), employee.getPassWordAccount())) {
                return employee;
            } else {
                throw new RuntimeException("Wrong password");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
