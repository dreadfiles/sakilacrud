package com.aaol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaol.entity.City;
import com.aaol.repository.CityRepository;

@RestController
@RequestMapping("/sakilacrudaordonez/city")
public class CityController {

	@Autowired
	CityRepository cityRepository;

	@GetMapping("/getAll")
	public List<City> getAll() {
		List<City> salida = null;
		try {
			salida = cityRepository.findAll();
		} catch (Exception e) {
			salida = null;
		}
		return salida;
	}

	@GetMapping("/get/{id}")
	public City get(@PathVariable Integer id) {
		City salida = null;
		try {
			salida = cityRepository.findOne(id);
		} catch (Exception e) {
			salida = null;
		}
		return salida;
	}

	@PostMapping("/post")
	public City add(@RequestBody City city) {
		City salida = null;
		try {
			cityRepository.save(city);
			salida = city;
		} catch (Exception e) {
			salida = null;
		}
		return salida;
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Integer id) {
		boolean salida = false;
		try {
			cityRepository.delete(id);
			salida = true;
		} catch (Exception e) {
			salida = false;
		}
		return salida;
	}

}