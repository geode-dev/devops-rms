package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    // Redirect root to login page
    @GetMapping("/")
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/login.html");
    }

    // Handle login form submit
    @PostMapping("/login")
    public void login(User user, HttpServletResponse response) throws IOException {

        if ("admin".equals(user.getUsername()) && "1234".equals(user.getPassword())) {
            response.sendRedirect("/success.html");
        } else {
            response.sendRedirect("/login.html?error=true");
        }
    }
}