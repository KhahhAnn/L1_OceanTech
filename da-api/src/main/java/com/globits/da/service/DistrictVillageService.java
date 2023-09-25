package com.globits.da.service;

import com.globits.da.dto.CityDistrictDtoRequest;
import com.globits.da.dto.CityDistrictDtoResponse;
import com.globits.da.dto.DistrictVillageDtoRequest;
import com.globits.da.dto.DistrictVillageDtoResponse;
import org.springframework.stereotype.Service;

@Service
public interface DistrictVillageService {
    public DistrictVillageDtoResponse addDistrictAndVillage(DistrictVillageDtoRequest request);

    public DistrictVillageDtoResponse updateDistrictAndVillage(DistrictVillageDtoRequest request);}
