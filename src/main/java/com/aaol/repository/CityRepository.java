package com.aaol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aaol.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}