package com.mobileshopweb.controller;

import com.mobileshopweb.dto.request.EmployeeCreationRequest;
import com.mobileshopweb.dto.request.EmployeeUpdateRequest;
import com.mobileshopweb.entity.Employee;
import com.mobileshopweb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    Employee createEmployee(@RequestBody EmployeeCreationRequest employeeCreationRequest) {
        return employeeService.createEmployee(employeeCreationRequest);
    }

    @GetMapping
    List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeID}")
    Employee getEmployee(@PathVariable("employeeID") String Id) {
        return employeeService.getEmployeeById(Id);
    }

    @PutMapping("/{employeeID}")
    Employee updateEmployee(@PathVariable("employeeID") String Id, @RequestBody EmployeeUpdateRequest employeeUpdateRequest) {
        return employeeService.updateEmployee(Id, employeeUpdateRequest);
    }

    @DeleteMapping("/{employeeID}")
    String deleteEmployee(@PathVariable("employeeID") String Id) {
        employeeService.deleteEmployee(Id);
        return "Employee deleted successfully";
    }
}
