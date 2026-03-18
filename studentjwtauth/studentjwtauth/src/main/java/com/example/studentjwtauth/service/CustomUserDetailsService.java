package com.example.studentjwtauth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.studentjwtauth.entity.Student;
import com.example.studentjwtauth.repository.StudentRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(student.getEmail())
                .password(student.getPassword())
                .roles("USER")
                .build();
    }
}