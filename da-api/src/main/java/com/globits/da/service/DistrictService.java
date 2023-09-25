package com.globits.da.service;

import com.globits.da.dto.CityDto;
import com.globits.da.dto.DistrictsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DistrictService {
    public List<DistrictsDto> getAll();

    public DistrictsDto addDistrict(DistrictsDto districtsDto);

    public DistrictsDto getById(Integer id);

    public DistrictsDto updateDistrict(Integer id, DistrictsDto districtsDto);

    public void deleteAll();

    public void deleteById(Integer id);

    public List<DistrictsDto> getDistrictByCity(Integer cityId);

}
