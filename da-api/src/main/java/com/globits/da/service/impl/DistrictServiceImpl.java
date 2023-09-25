package com.globits.da.service.impl;

import com.globits.da.domain.District;
import com.globits.da.dto.CityDto;
import com.globits.da.dto.DistrictsDto;
import com.globits.da.repository.DistrictRepository;
import com.globits.da.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    @Override
    public List<DistrictsDto> getAll() {
        List<District> districts = this.districtRepository.findAll();
        List<DistrictsDto> districtsDtos = new ArrayList<DistrictsDto>();
        districtsDtos.addAll(districts.stream().map(
                        district -> new DistrictsDto(district))
                .collect(Collectors.toList())
        );
        return districtsDtos;
    }

    @Override
    public DistrictsDto addDistrict(DistrictsDto districtsDto) {
        if(districtsDto == null) {
            return null;
        }
        District district = new District();
        district.setId(districtsDto.getId());
        district.setName(districtsDto.getName());
        this.districtRepository.saveAndFlush(district);
        return districtsDto;
    }

    @Override
    public DistrictsDto getById(Integer id) {
        if(id == null) {
            return null;
        }
        District district = this.districtRepository.getOne(id);
        DistrictsDto districtsDto = new DistrictsDto(district);
        return districtsDto;
    }

    @Override
    public DistrictsDto updateDistrict(Integer id, DistrictsDto villageDto) {
        if(this.districtRepository.getOne(id) != null) {
            DistrictsDto districtsDtoExists = new DistrictsDto(this.districtRepository.getOne(id));
            districtsDtoExists.setId(villageDto.getId());
            districtsDtoExists.setName(villageDto.getName());
            this.districtRepository.saveAndFlush(this.districtRepository.getOne(id));
            return districtsDtoExists;
        }
        return null;
    }

    @Override
    public void deleteAll() {
        this.districtRepository.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        if(id == null) {
            return;
        }
        District district = this.districtRepository.getOne(id);
        this.deleteById(id);
    }

    @Override
    public List<DistrictsDto> getDistrictByCity(Integer cityId) {
        List<District> districtList = this.districtRepository.findAllById(cityId);
        List<DistrictsDto> districtsDtoList = new ArrayList<>();
        districtsDtoList.addAll(districtList.stream().map(
                district -> new DistrictsDto(district)).
                collect(Collectors.toList())
        );
        return districtsDtoList;
    }
}
