package com.globits.da.service;

import com.globits.da.dto.VillageDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VillageService {
    public List<VillageDto> getAll();

    public VillageDto addVillage(VillageDto villageDto);

    public VillageDto getById(Integer id);

    public VillageDto updateVillage(Integer id, VillageDto villageDto);

    public void deleteAll();

    public void deleteById(Integer id);

}
