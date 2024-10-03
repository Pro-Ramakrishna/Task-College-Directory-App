package com.ram.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.model.FacultyProfile;
import com.ram.service.UserService;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<FacultyProfile> getFacultyById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getFacultyById(id));
    }

    @PostMapping
    public ResponseEntity<FacultyProfile> createFaculty(@RequestBody FacultyProfile facultyProfile) {
        return ResponseEntity.ok(userService.createFaculty(facultyProfile));
    }
}
