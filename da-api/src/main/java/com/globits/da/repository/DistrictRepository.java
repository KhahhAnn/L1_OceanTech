package com.globits.da.repository;

import com.globits.da.domain.District;
import com.globits.da.dto.CityDto;
import com.globits.da.dto.DistrictsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {
    @Query("SELECT d FROM District d WHERE d.city.id = ?1")
    public List<District> findAllById(Integer cityId);
}
