package com.globits.da.dto;

import com.globits.core.dto.BaseObjectDto;
import com.globits.da.domain.Employee;

import java.util.UUID;

public class EmployeeDto{
    private Integer id;
    private String code;
    private String email;
    private String name;
    private String phone;
    private Integer age;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String code, String email, String name, String phone, Integer age) {
        this.id = id;
        this.code = code;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public EmployeeDto(Employee employee) {
        if (employee != null) {
            this.setId(employee.getId());
            this.setName(employee.getName());
            this.setAge(employee.getAge());
            this.setCode(employee.getCode());
            this.setEmail(employee.getEmail());
            this.setPhone(employee.getPhone());
        }
    }
}
