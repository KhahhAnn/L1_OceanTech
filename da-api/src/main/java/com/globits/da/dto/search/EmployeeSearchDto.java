package com.globits.da.dto.search;

public class EmployeeSearchDto {
    private Integer id;
    private String code;
    private String email;
    private String phone;

    public EmployeeSearchDto() {
    }

    public EmployeeSearchDto(Integer id, String code, String email, String phone) {
        this.id = id;
        this.code = code;
        this.email = email;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
