package com.springpoc.ishaan.demo.services;

import com.springpoc.ishaan.demo.dto.EmployeeDTO;
import com.springpoc.ishaan.demo.entities.EmployeeEntity;
import com.springpoc.ishaan.demo.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        //return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getDateOfJoining(), employeeEntity.getIsActive());

        //use modelMapper here
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
       EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
       return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
