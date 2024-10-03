package com.ram.service;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.model.FacultyProfile;
import com.ram.model.StudentProfile;
import com.ram.model.User;
import com.ram.repository.FacultyProfileRepository;
import com.ram.repository.StudentProfileRepository;
import com.ram.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public StudentProfile getStudentById(Long id) {
        return studentProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public StudentProfile createStudent(StudentProfile studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }

    public FacultyProfile getFacultyById(Long id) {
        return facultyProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Faculty not found"));
    }

    public FacultyProfile createFaculty(FacultyProfile facultyProfile) {
        return facultyProfileRepository.save(facultyProfile);
    }

    public User createAdmin(User admin) {
        return userRepository.save(admin);
    }
}

