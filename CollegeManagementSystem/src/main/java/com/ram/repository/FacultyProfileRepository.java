package com.ram.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.model.FacultyProfile;

public interface FacultyProfileRepository extends JpaRepository<FacultyProfile, Long> {
}
