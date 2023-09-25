package com.globits.da.service.impl;

import com.globits.core.service.GenericService;
import com.globits.core.service.impl.GenericServiceImpl;
import com.globits.da.domain.Category;
import com.globits.da.domain.Employee;
import com.globits.da.dto.EmployeeDto;
import com.globits.da.repository.EmployeeRepository;
import com.globits.da.service.EmployeeService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employeeList = this.employeeRepository.findAll();
        if(employeeList == null) {
            return null;
        }
        List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
        employeeDtos.addAll(
                employeeList.stream()
                        .map(employee -> new EmployeeDto(employee))
                        .collect(Collectors.toList())
        );
        return employeeDtos;
    }

    @Override
    public EmployeeDto addEmployeeDto(EmployeeDto employeeDto) {
        Employee newEmployee = new Employee();
        newEmployee.setEmail(employeeDto.getEmail());
        newEmployee.setCode(employeeDto.getCode());
        newEmployee.setName(employeeDto.getName());
        newEmployee.setPhone(employeeDto.getPhone());
        newEmployee.setAge(employeeDto.getAge());
        this.employeeRepository.saveAndFlush(newEmployee);
        return employeeDto;
    }

    @Override
    public EmployeeDto getById(Integer id) {
        if(id == null) {
            return null;
        }
        Employee employee = this.employeeRepository.getOne(id);
        EmployeeDto employeeDto = new EmployeeDto(employee);
        return employeeDto;
    }

    @Override
    public void deleteAll() {
        this.employeeRepository.deleteAll();
    }

    @Override
    public void generateExcel(HttpServletResponse response) {
        List<Employee> employeeList = this.employeeRepository.findAll();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employee Info");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Age");
        row.createCell(2).setCellValue("Code");
        row.createCell(3).setCellValue("Email");
        row.createCell(4).setCellValue("Name");
        row.createCell(5).setCellValue("Phone");
        
        int dataRowIndex = 1;
        for (Employee employee : employeeList) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(employee.getId());
            dataRow.createCell(1).setCellValue(employee.getAge());
            dataRow.createCell(2).setCellValue(employee.getCode());
            dataRow.createCell(3).setCellValue(employee.getEmail());
            dataRow.createCell(4).setCellValue(employee.getName());
            dataRow.createCell(5).setCellValue(employee.getPhone());
            dataRowIndex++;
        }
        try {
            ServletOutputStream ops = response.getOutputStream();
            workbook.write(ops);
            workbook.close();
            ops.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
