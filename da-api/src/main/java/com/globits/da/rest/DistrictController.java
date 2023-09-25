package com.globits.da.rest;

import com.globits.da.dto.CityDto;
import com.globits.da.dto.DistrictsDto;
import com.globits.da.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @GetMapping()
    public ResponseEntity<List<DistrictsDto>> getAll() {
        List<DistrictsDto> districtsDtos = this.districtService.getAll();
        return new ResponseEntity<List<DistrictsDto>>(districtsDtos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DistrictsDto> getById(@PathVariable Integer id) {
        DistrictsDto districtsDto = this.districtService.getById(id);
        return new ResponseEntity<DistrictsDto>(districtsDto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DistrictsDto> addCity(@RequestBody DistrictsDto districtsDto) {
        this.districtService.addDistrict(districtsDto);
        return new ResponseEntity<DistrictsDto>(districtsDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public String updateCity(@PathVariable Integer id, @RequestBody DistrictsDto districtsDto) {
        this.districtService.updateDistrict(id, districtsDto);
        return "update complete";
    }

    @DeleteMapping()
    public String deleteAll() {
        this.districtService.deleteAll();
        return "delete complete";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        this.districtService.deleteById(id);
        return "delete complete";
    }
}
