package com.ram.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "administratorprofile")
public class administratorprofile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Foreign key to User entity

    private String photo;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department; // Foreign key to Department entity

 public administratorprofile() {
    	
    }
 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public User getUser() {
     return user;
 }

 public void setUser(User user) {
     this.user = user;
 }

 public String getPhoto() {
     return photo;
 }

 public void setPhoto(String photo) {
     this.photo = photo;
 }

 public Department getDepartment() {
     return department;
 }

 public void setDepartment(Department department) {
     this.department = department;
 } 
}
