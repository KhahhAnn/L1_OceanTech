package com.globits.da.rest;

import com.globits.da.dto.CityDto;
import com.globits.da.dto.DistrictsDto;
import com.globits.da.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping()
    public ResponseEntity<List<CityDto>> getAll() {
        List<CityDto> cityDtoList = this.cityService.getAll();
        return new ResponseEntity<List<CityDto>>(cityDtoList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CityDto> getById(@PathVariable  Integer id) {
        CityDto cityDto = this.cityService.getById(id);
        return new ResponseEntity<CityDto>(cityDto, HttpStatus.OK);
    }

    @GetMapping("/{id}/districts")
    public ResponseEntity<List<DistrictsDto>> getDistrictsByCity(@PathVariable Integer id) {
        List<DistrictsDto> districtsDtoList = this.cityService.getAllDistrictByCity(id);
        return new ResponseEntity<List<DistrictsDto>>(districtsDtoList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CityDto> addCity(@RequestBody CityDto cityDto) {
        this.cityService.addCity(cityDto);
        return new ResponseEntity<CityDto>(cityDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public String updateCity(@PathVariable Integer id, @RequestBody CityDto cityDto) {
        this.cityService.updateCity(id, cityDto);
        return "update complete";
    }

    @DeleteMapping()
    public String deleteAll() {
        this.cityService.deleteAll();
        return "delete complete";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        this.cityService.deleteById(id);
        return "delete complete";
    }

}
