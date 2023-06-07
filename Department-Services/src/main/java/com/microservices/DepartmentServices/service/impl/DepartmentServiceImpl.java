package com.microservices.DepartmentServices.service.impl;

import com.microservices.DepartmentServices.dto.DepartmentDto;
import com.microservices.DepartmentServices.entity.Department;
import com.microservices.DepartmentServices.mapper.DepartmentMapper;
import com.microservices.DepartmentServices.repository.DepartmentRepository;
import com.microservices.DepartmentServices.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Override
    public DepartmentDto createNewDepartment(DepartmentDto departmentDto) {
        logger.info("Create New Department Method");
        Department department = DepartmentMapper.mapperToDepartment(departmentDto);

        Department SavedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapperToDepartmentDto(SavedDepartment);
    }

    @Override
    public DepartmentDto findDepartmentByDepartmentCode(String code) {

        logger.info("Find Department By Department Code Method");
        Department department =  departmentRepository.findDepartmentByCode(code);

        return DepartmentMapper.mapperToDepartmentDto(department);
    }

    @Override
    public DepartmentDto updateDepartmentInfo(DepartmentDto departmentDto) {
        logger.info("Update Department Info Method");
        DepartmentDto departmentDto1 = null;
        Department oldDepartment = departmentRepository.findDepartmentByCode(departmentDto.getCode());
        if(oldDepartment != null)
        {
            Department updateDepartment = new Department(
                    oldDepartment.getId(),
                    departmentDto.getName(),
                    departmentDto.getDescription(),
                    departmentDto.getCode());
            Department updatedDepartment = departmentRepository.save(updateDepartment);
            departmentDto1 = DepartmentMapper.mapperToDepartmentDto(updatedDepartment);
        }
        return departmentDto1;
    }
}
