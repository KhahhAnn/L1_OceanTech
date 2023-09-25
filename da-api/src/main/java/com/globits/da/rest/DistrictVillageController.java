package com.globits.da.rest;

import com.globits.da.dto.DistrictVillageDtoRequest;
import com.globits.da.dto.DistrictVillageDtoResponse;
import com.globits.da.service.DistrictVillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/districtVillage")
public class DistrictVillageController {
    @Autowired
    private DistrictVillageService districtVillageService;

    @PostMapping()
    public ResponseEntity<DistrictVillageDtoResponse> addDistrictAndVillage(@RequestBody DistrictVillageDtoRequest request) {
        DistrictVillageDtoResponse response = this.districtVillageService.addDistrictAndVillage(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistrictVillageDtoResponse> updateDistrictAndVillage(@PathVariable Integer id, @RequestBody DistrictVillageDtoRequest request) {
        request.getDistrict().setId(id);
        DistrictVillageDtoResponse response = this.districtVillageService.updateDistrictAndVillage(request);
        return ResponseEntity.ok(response);
    }
}
