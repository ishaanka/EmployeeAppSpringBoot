package com.springpoc.ishaan.demo.controllers;

import com.springpoc.ishaan.demo.dto.EmployeeDTO;
import com.springpoc.ishaan.demo.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Path variable(mandate one), path param(optional)
    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployees(@PathVariable("id") Long employeeId) {
        //return new EmployeeDTO(employeeId,"Ishaan", LocalDate.of(2024,1,2),true);
        return employeeService.getEmployeeById(employeeId);
    }

    //localhost:8080/employees?sortBy="String"
    @GetMapping
    public String getData(@PathParam("sortBy") String sortBy) {
        return "Hello "+sortBy;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createNewEmployee(employeeDTO);
    }
}
