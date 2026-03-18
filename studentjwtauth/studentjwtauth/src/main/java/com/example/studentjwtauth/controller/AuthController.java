package com.example.studentjwtauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentjwtauth.dto.AuthRequest;
import com.example.studentjwtauth.dto.AuthResponse;
import com.example.studentjwtauth.entity.Student;
import com.example.studentjwtauth.service.JwtService;
import com.example.studentjwtauth.service.StudentService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public Student register(@RequestBody Student student) {
        return studentService.register(student);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        String token = jwtService.generateToken(request.getEmail());
        return new AuthResponse(token);
    }
}