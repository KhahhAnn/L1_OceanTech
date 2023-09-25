package com.globits.da.rest;


import com.globits.da.dto.DistrictsDto;
import com.globits.da.dto.VillageDto;
import com.globits.da.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/village")
public class VillageController {
    @Autowired
    private VillageService villageService;
    @GetMapping()
    public ResponseEntity<List<VillageDto>> getAll() {
        List<VillageDto> villageDtoList = this.villageService.getAll();
        return new ResponseEntity<List<VillageDto>>(villageDtoList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<VillageDto> getById(@PathVariable Integer id) {
        VillageDto villageDto = this.villageService.getById(id);
        return new ResponseEntity<VillageDto>(villageDto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<VillageDto> addCity(@RequestBody VillageDto villageDto) {
        this.villageService.addVillage(villageDto);
        return new ResponseEntity<VillageDto>(villageDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public String updateCity(@PathVariable Integer id, @RequestBody VillageDto villageDto) {
        this.villageService.updateVillage(id, villageDto);
        return "update complete";
    }

    @DeleteMapping()
    public String deleteAll() {
        this.villageService.deleteAll();
        return "delete complete";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id) {
        this.villageService.deleteById(id);
        return "delete complete";
    }
}
