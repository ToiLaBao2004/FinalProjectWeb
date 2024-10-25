package com.mobileshopweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.mobileshopweb.dto.request.EmployeeLoginRequest;
import com.mobileshopweb.entity.Employee;
import com.mobileshopweb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeLoginController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/adminlogin")
    public String showLoginPage() {
        return "adminlogin";
    }

    @PostMapping("/login")
    public String loginEmployee(@ModelAttribute EmployeeLoginRequest employeeLoginRequest, RedirectAttributes redirectAttributes) {
        try {
            Employee employee = employeeService.login(employeeLoginRequest);
            return "redirect:/dashboard";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/adminlogin";
        }
    }
}
