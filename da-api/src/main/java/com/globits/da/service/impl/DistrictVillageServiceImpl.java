package com.globits.da.service.impl;

import com.globits.da.domain.District;
import com.globits.da.domain.Village;
import com.globits.da.dto.DistrictVillageDtoRequest;
import com.globits.da.dto.DistrictVillageDtoResponse;
import com.globits.da.repository.DistrictRepository;
import com.globits.da.repository.VillageRepository;
import com.globits.da.service.DistrictVillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictVillageServiceImpl implements DistrictVillageService {
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private VillageRepository villageRepository;
    @Override
    public DistrictVillageDtoResponse addDistrictAndVillage(DistrictVillageDtoRequest request) {
        District district = request.getDistrict();
        List<Village> villages = request.getVillageList();
        district = this.districtRepository.saveAndFlush(district);
        for(Village village : villages) {
            village.setDistrict(district);
        }
        villages = this.villageRepository.saveAll(villages);
        return new DistrictVillageDtoResponse(district, villages);
    }

    @Override
    public DistrictVillageDtoResponse updateDistrictAndVillage(DistrictVillageDtoRequest request) {
        District district = request.getDistrict();
        List<Village> villages = request.getVillageList();
        district = this.districtRepository.saveAndFlush(district);
        district = this.districtRepository.findById(district.getId()).orElse(null);
        for (Village village: villages) {
            if(village.getId() != null) {
                Village existingVillage = this.villageRepository.findById(district.getId()).orElse(null);
                if(existingVillage != null) {
                    existingVillage.setName(village.getName());
                    this.villageRepository.saveAndFlush(existingVillage);
                }
            }
        }
        return new DistrictVillageDtoResponse(district, villages);
    }
}
