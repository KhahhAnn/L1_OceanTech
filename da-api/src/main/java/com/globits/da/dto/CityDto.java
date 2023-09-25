package com.globits.da.dto;

import com.globits.da.domain.City;
import com.globits.da.domain.District;

import java.util.List;

public class CityDto {
    private Integer id;
    private String name;
    private List<District> districtList;

    public CityDto() {
    }

    public CityDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }

    public CityDto(City city) {
        if(city != null) {
            this.setId(city.getId());
            this.setName(city.getName());
            this.setDistrictList(this.getDistrictList());
        }
    }
}
