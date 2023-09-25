package com.globits.da.dto;

import com.globits.da.domain.City;
import com.globits.da.domain.District;

public class DistrictsDto {
    private Integer id;
    private String name;
    private City city;


    public DistrictsDto(Integer id, String name) {
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public DistrictsDto(District district) {
        if(district != null) {
            this.setId(district.getId());
            this.setName(district.getName());
            this.setCity(district.getCity());
        }
    }
}
