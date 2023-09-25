package com.globits.da.service;

import com.globits.da.dto.CityDto;
import com.globits.da.dto.DistrictsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {
    public List<CityDto> getAll();

    public CityDto addCity(CityDto cityDto);

    public CityDto getById(Integer id);

    public CityDto updateCity(Integer id, CityDto cityDto);

    public void deleteAll();

    public void deleteById(Integer id);

    public List<DistrictsDto> getAllDistrictByCity(Integer id);
}
