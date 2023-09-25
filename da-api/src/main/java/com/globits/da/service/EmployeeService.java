package com.globits.da.service;

import com.globits.core.service.GenericService;
import com.globits.da.domain.Employee;
import com.globits.da.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Service
public interface EmployeeService{
    public List<EmployeeDto> getAllEmployee();

    public EmployeeDto addEmployeeDto(EmployeeDto employeeDto);

    public EmployeeDto getById(Integer id);

    public void deleteAll();

    public void generateExcel(HttpServletResponse response);
}
