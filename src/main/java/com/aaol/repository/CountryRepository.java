package com.aaol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aaol.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}