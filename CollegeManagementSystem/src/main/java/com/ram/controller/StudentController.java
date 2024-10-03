package com.ram.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.model.StudentProfile;
import com.ram.service.UserService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentProfile> createStudent(@RequestBody StudentProfile studentProfile) {
        return ResponseEntity.ok(userService.createStudent(studentProfile));
    }
}
