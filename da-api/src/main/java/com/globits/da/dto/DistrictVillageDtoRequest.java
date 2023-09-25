package com.globits.da.dto;

import com.globits.da.domain.District;
import com.globits.da.domain.Village;

import java.util.List;

public class DistrictVillageDtoRequest {
    private District district;
    private List<Village> villageList;

    public DistrictVillageDtoRequest() {
    }

    public DistrictVillageDtoRequest(District district, List<Village> villageList) {
        this.district = district;
        this.villageList = villageList;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<Village> getVillageList() {
        return villageList;
    }

    public void setVillageList(List<Village> villageList) {
        this.villageList = villageList;
    }
}
