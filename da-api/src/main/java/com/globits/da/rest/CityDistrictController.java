package com.globits.da.rest;

import com.globits.da.dto.CityDistrictDtoRequest;
import com.globits.da.dto.CityDistrictDtoResponse;
import com.globits.da.service.CityDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cityDistrict")
public class CityDistrictController {
    @Autowired
    private CityDistrictService cityDistrictService;
    @PostMapping()
    public ResponseEntity<CityDistrictDtoResponse> themTinhHuyen(@RequestBody CityDistrictDtoRequest request) {
        CityDistrictDtoResponse response = this.cityDistrictService.addCityAndDistrict(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{/id}")
    public ResponseEntity<CityDistrictDtoResponse> suaTinhHuyen(@PathVariable Integer id, @RequestBody CityDistrictDtoRequest request) {
        CityDistrictDtoResponse response = this.cityDistrictService.updateCityAndDistrict(request);
        return ResponseEntity.ok(response);
    }
}
