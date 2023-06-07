package com.microservices.EmployeeServices.controller;

import com.microservices.EmployeeServices.dto.EmployeeDto;
import com.microservices.EmployeeServices.dto.ResponseAPI;
import com.microservices.EmployeeServices.dto.UpdateDto;
import com.microservices.EmployeeServices.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/employee")

public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/createNewEmployee_OpenFeign")
    public ResponseEntity<ResponseAPI> createNewEmployee_OpenFeign(@RequestBody EmployeeDto employeeDto)
    {
        return new ResponseEntity<>(employeeService.createNewEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("/getEmployeeById_OpenFeign/{id}")
    public ResponseEntity<ResponseAPI> getEmployeeById_OpenFeign(@PathVariable("id") Long id)
    {
        return new ResponseEntity<>(employeeService.getEmployeeByEmployeeID(id), HttpStatus.OK);
    }

    @PutMapping("/updateEmployeeInfo")
    public ResponseEntity<ResponseAPI> updateEmployeeInfo(@RequestBody UpdateDto dto)
    {
        return new ResponseEntity<>(employeeService.updateEmployeeInfo(dto), HttpStatus.OK);
    }
}
