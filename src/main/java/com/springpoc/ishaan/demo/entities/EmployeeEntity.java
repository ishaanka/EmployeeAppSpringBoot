package com.springpoc.ishaan.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate dateOfJoining;
    private Boolean isActive;
}
