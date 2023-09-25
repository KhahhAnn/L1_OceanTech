package com.globits.da.service;

import com.globits.da.dto.CityDistrictDtoRequest;
import com.globits.da.dto.CityDistrictDtoResponse;
import org.springframework.stereotype.Service;

@Service
public interface CityDistrictService {
    public CityDistrictDtoResponse addCityAndDistrict(CityDistrictDtoRequest request);

    public CityDistrictDtoResponse updateCityAndDistrict(CityDistrictDtoRequest request);
}
