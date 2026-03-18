package com.example.studentjwtauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentjwtauth.entity.Student;
import com.example.studentjwtauth.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student register(Student student) {
        return repo.save(student);
    }

    public Student getProfile(String email) {
        return repo.findByEmail(email).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}