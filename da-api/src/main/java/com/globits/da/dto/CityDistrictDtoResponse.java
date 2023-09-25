package com.globits.da.dto;

import com.globits.da.domain.City;
import com.globits.da.domain.District;

import java.util.List;

public class CityDistrictDtoResponse {
    private City city;
    private List<District> districtList;

    public CityDistrictDtoResponse() {
    }

    public CityDistrictDtoResponse(City city, List<District> districtList) {
        this.city = city;
        this.districtList = districtList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }
}
