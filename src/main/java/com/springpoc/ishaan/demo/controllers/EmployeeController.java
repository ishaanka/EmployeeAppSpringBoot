package com.springpoc.ishaan.demo.controllers;

import com.springpoc.ishaan.demo.dto.EmployeeDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
public class EmployeeController {

    //Path variable(mandate one), path param(optional)
    @GetMapping(path = "/employees/{id}")
    public EmployeeDTO getEmployees(@PathVariable("id") Long employeeId) {
        return new EmployeeDTO(employeeId,"Ishaan", LocalDate.of(2024,1,2),true);
    }

    //localhost:8080/employees?sortBy="String"
    @GetMapping(path = "/employees")
    public String getData(@PathParam("sortBy") String sortBy) {
        return "Hello "+sortBy;
    }
}
