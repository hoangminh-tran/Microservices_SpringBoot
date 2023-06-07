package com.microservices.EmployeeServices.service;

import com.microservices.EmployeeServices.dto.EmployeeDto;
import com.microservices.EmployeeServices.dto.ResponseAPI;
import com.microservices.EmployeeServices.dto.UpdateDto;

public interface EmployeeService {
    ResponseAPI createNewEmployee(EmployeeDto dto);

    ResponseAPI getEmployeeByEmployeeID(Long EmployeeId);

    ResponseAPI updateEmployeeInfo(UpdateDto dto);
}
