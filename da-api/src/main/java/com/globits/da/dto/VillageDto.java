package com.globits.da.dto;

import com.globits.da.domain.City;
import com.globits.da.domain.Village;

public class VillageDto {
    private Integer id;
    private String name;

    public VillageDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public VillageDto(Village village) {
        if(village != null) {
            this.setId(village.getId());
            this.setName(village.getName());
        }
    }
}
