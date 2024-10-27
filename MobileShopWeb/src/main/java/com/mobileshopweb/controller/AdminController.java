package com.mobileshopweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin") // Đường dẫn mới
    public String goHome() {
        return "index"; // Vẫn trả về file index.html
    }
}
