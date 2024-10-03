package com.ram.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.model.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
}
