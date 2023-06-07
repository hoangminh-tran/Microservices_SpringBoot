package com.microservices.DepartmentServices.controller;

import com.microservices.DepartmentServices.dto.DepartmentDto;
import com.microservices.DepartmentServices.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> createNewDepartment(@RequestBody DepartmentDto dto)
    {
        return new ResponseEntity<>(departmentService.createNewDepartment(dto), HttpStatus.CREATED);
    }

    @GetMapping("/findDepartmentByCode/{code}")
    public ResponseEntity<DepartmentDto> findDepartmentByDepartmentCode(@PathVariable("code") String code)
    {
        return new ResponseEntity<>(departmentService.findDepartmentByDepartmentCode(code), HttpStatus.OK);
    }

    @PutMapping("/updateDepartmentInfo")
    public ResponseEntity<DepartmentDto> updateDepartmentInfo(@RequestBody DepartmentDto dto)
    {
        return new ResponseEntity<>(departmentService.updateDepartmentInfo(dto), HttpStatus.OK);
    }
}
