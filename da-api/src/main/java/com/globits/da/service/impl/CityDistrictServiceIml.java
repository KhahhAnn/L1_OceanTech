package com.globits.da.service.impl;

import com.globits.da.domain.City;
import com.globits.da.domain.District;
import com.globits.da.dto.CityDistrictDtoRequest;
import com.globits.da.dto.CityDistrictDtoResponse;
import com.globits.da.repository.CityRepository;
import com.globits.da.repository.DistrictRepository;
import com.globits.da.service.CityDistrictService;
import com.globits.da.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityDistrictServiceIml implements CityDistrictService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Override
    public CityDistrictDtoResponse addCityAndDistrict(CityDistrictDtoRequest request) {
        City city = request.getCity();
        List<District> districtList = request.getDistrictList();
        city = this.cityRepository.saveAndFlush(city);

        for(District district : districtList) {
            district.setCity(city);
        }
        districtList = this.districtRepository.saveAll(districtList);

        return new CityDistrictDtoResponse(city, districtList);
    }

    @Override
    public CityDistrictDtoResponse updateCityAndDistrict(CityDistrictDtoRequest request) {
        City city = request.getCity();
        List<District> districtList = request.getDistrictList();
        city = this.cityRepository.saveAndFlush(city);
        city = this.cityRepository.findById(city.getId()).orElse(null);
        for (District district: districtList) {
            if(district.getId() != null) {
                District existingDistrict = this.districtRepository.findById(district.getId()).orElse(null);
                if(existingDistrict != null) {
                    existingDistrict.setName(district.getName());
                    this.districtRepository.saveAndFlush(existingDistrict);
                }
            }
        }
        return new CityDistrictDtoResponse(city, districtList);
    }
}
