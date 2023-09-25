package com.globits.da.service.impl;


import com.globits.da.domain.Village;
import com.globits.da.dto.VillageDto;
import com.globits.da.repository.VillageRepository;
import com.globits.da.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VillageServiceImpl implements VillageService {
    @Autowired
    private VillageRepository villageRepository;
    @Override
    public List<VillageDto> getAll() {
        List<Village> villages = this.villageRepository.findAll();
        List<VillageDto> villageDtos = new ArrayList<VillageDto>();
        villageDtos.addAll(villages.stream().map(
                village -> new VillageDto(village))
                .collect(Collectors.toList())
        );
        return villageDtos;
    }

    @Override
    public VillageDto addVillage(VillageDto villageDto) {
        if(villageDto == null) {
            return null;
        }
        Village newVillage = new Village();
        newVillage.setId(villageDto.getId());
        newVillage.setName(villageDto.getName());
        this.villageRepository.saveAndFlush(newVillage);
        return villageDto;
    }

    @Override
    public VillageDto getById(Integer id) {
        if(id == null) {
            return null;
        }
        Village village = this.villageRepository.getOne(id);
        VillageDto villageDto = new VillageDto(village);
        return villageDto;
    }

    @Override
    public VillageDto updateVillage(Integer id, VillageDto villageDto) {
        if(this.villageRepository.getOne(id) != null) {
            VillageDto villageDtoExists = new VillageDto(this.villageRepository.getOne(id));
            villageDtoExists.setId(villageDto.getId());
            villageDtoExists.setName(villageDto.getName());
            this.villageRepository.saveAndFlush(this.villageRepository.getOne(id));
            return villageDtoExists;
        }
        return null;
    }

    @Override
    public void deleteAll() {
        this.villageRepository.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        if(id == null) {
            return;
        }
        Village village = this.villageRepository.getOne(id);
        this.deleteById(id);
    }
}
