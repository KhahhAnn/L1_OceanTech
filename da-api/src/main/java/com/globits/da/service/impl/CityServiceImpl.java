package com.globits.da.service.impl;

import com.globits.da.domain.City;
import com.globits.da.domain.District;
import com.globits.da.dto.CityDto;
import com.globits.da.dto.DistrictsDto;
import com.globits.da.repository.CityRepository;
import com.globits.da.repository.DistrictRepository;
import com.globits.da.service.CityService;
import com.globits.da.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DistrictService districtService;
    @Override
    public List<CityDto> getAll() {
        List<City> cities = this.cityRepository.findAll();
        List<CityDto> cityDtos = new ArrayList<CityDto>();
        cityDtos.addAll(cities.stream().map(
                        city -> new CityDto(city))
                .collect(Collectors.toList())
        );
        return cityDtos;
    }

    @Override
    public CityDto addCity(CityDto cityDto) {
        if(cityDto == null) {
            return null;
        }
        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        this.cityRepository.saveAndFlush(city);
        return cityDto;
    }

    @Override
    public CityDto getById(Integer id) {
        if(id == null) {
            return null;
        }
        City city = this.cityRepository.getOne(id);
        CityDto cityDto = new CityDto(city);
        return cityDto;
    }

    @Override
    public CityDto updateCity(Integer id, CityDto cityDto) {
        if(this.cityRepository.getOne(id) != null) {
            CityDto cityDtoExists = new CityDto(this.cityRepository.getOne(id));
            cityDtoExists.setId(cityDto.getId());
            cityDtoExists.setName(cityDto.getName());
            this.cityRepository.saveAndFlush(this.cityRepository.getOne(id));
            return cityDtoExists;
        }
        return null;
    }

    @Override
    public void deleteAll() {
        this.cityRepository.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        if(id == null) {
            return;
        }
        City city = this.cityRepository.getOne(id);
        this.deleteById(id);
    }

    @Override
    public List<DistrictsDto> getAllDistrictByCity(Integer id) {
        City city = this.cityRepository.getOne(id);
        return this.districtService.getDistrictByCity(city.getId());
    }

}
