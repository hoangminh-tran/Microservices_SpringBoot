package com.microservices.EmployeeServices.service.impl;

import com.microservices.EmployeeServices.dto.*;
import com.microservices.EmployeeServices.entity.Employee;
import com.microservices.EmployeeServices.mapper.EmployeeMapper;
import com.microservices.EmployeeServices.repository.EmployeeRepository;
import com.microservices.EmployeeServices.service.FeignClient_Department;
import com.microservices.EmployeeServices.service.EmployeeService;
import com.microservices.EmployeeServices.service.FeignClient_Organization;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final FeignClient_Department feignClientDepartment;

    private final FeignClient_Organization feignClientOrganization;

    @Override
    public ResponseAPI createNewEmployee(EmployeeDto dto) {
        logger.info("Create New Employee Method");

        DepartmentDto departmentDto = feignClientDepartment.findDepartmentByDepartmentCode(dto.getDepartment_code());

        logger.info("{} : {}", "Department Name", departmentDto.getName());

        OrganizationDto organizationDto = feignClientOrganization.getOrganizationByCode(dto.getOrganization_code());

        logger.info("{} : {}", "Organizagtion Description", organizationDto.getDescription());

        Employee employee = EmployeeMapper.mapperToEmployee(dto);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto employeeDto = EmployeeMapper.mapperToEmployeeDto(savedEmployee);

        return new ResponseAPI(departmentDto, employeeDto, organizationDto);
    }

    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public ResponseAPI getEmployeeByEmployeeID(Long EmployeeId) {
        logger.info("Get Employee By Employee ID");

        Employee employee = employeeRepository.getEmployeeById(EmployeeId);

        DepartmentDto departmentDto = feignClientDepartment.findDepartmentByDepartmentCode(employee.getDepartment_code());

        logger.info("{} : {}", "Department Name", departmentDto.getName());

        OrganizationDto organizationDto = feignClientOrganization.getOrganizationByCode(employee.getOrganization_code());

        logger.info("{} : {}", "Organizagtion Description", organizationDto.getDescription());

        EmployeeDto employeeDto = EmployeeMapper.mapperToEmployeeDto(employee);

        return new ResponseAPI(departmentDto, employeeDto, organizationDto);
    }

    public ResponseAPI getDefaultDepartment(Long EmployeeId, Exception exception)
    {
        logger.info("Inside GetDefaultDepartment By Using CircuitBreaker");

        Employee employee = employeeRepository.getEmployeeById(EmployeeId);

        EmployeeDto employeeDto = EmployeeMapper.mapperToEmployeeDto(employee);

        DepartmentDto departmentDto = new DepartmentDto("Media Department", "Media and Entertainment Department", "ME001");

        OrganizationDto organizationDto = new OrganizationDto("Fpt Software", "Asia Singapore Europe", "FHM_ADG", LocalDate.parse("2021-01-02"));

        return new ResponseAPI(departmentDto, employeeDto, organizationDto);
    }

    @Override
    public ResponseAPI updateEmployeeInfo(UpdateDto dto) {
        logger.info("Update Employee Info method");

        Employee employee = employeeRepository.findById(dto.getEmployee_id()).get();
        // Update Department Information
        logger.info("{} : {}", "The id of the Employee", employee.getId());

        DepartmentDto departmentDto = feignClientDepartment.findDepartmentByDepartmentCode(employee.getDepartment_code());

        OrganizationDto organizationDto = feignClientOrganization.getOrganizationByCode(employee.getOrganization_code());

        DepartmentDto updateDepartmentDto = new DepartmentDto(
                departmentDto.getId(),
                dto.getDepartment_name(),
                dto.getDepartment_description(),
                departmentDto.getCode());

        DepartmentDto updated = feignClientDepartment.updateDepartmentInfo(updateDepartmentDto);

        //Update the Employee Information
        Employee updatedEmployee = new Employee(
                employee.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                employee.getEmail(),
                employee.getDepartment_code(),
                employee.getOrganization_code()
        );
        Employee savedEmployee = employeeRepository.save(updatedEmployee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapperToEmployeeDto(savedEmployee);

        return new ResponseAPI(updateDepartmentDto, savedEmployeeDto, organizationDto);
    }
}
