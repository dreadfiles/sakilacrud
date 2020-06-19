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

import com.aaol.entity.Country;
import com.aaol.repository.CountryRepository;

@RestController
@RequestMapping("/sakila/country")
public class CountryController {

	@Autowired
	CountryRepository countryRepository;

	@GetMapping("/getAll")
	public List<Country> getAll() {
		List<Country> salida = null;
		try {
			salida = countryRepository.findAll();
		} catch (Exception e) {
			salida = null;
		}
		return salida;
	}

	@GetMapping("/get/{id}")
	public Country get(@PathVariable Integer id) {
		Country salida = null;
		try {
			salida = countryRepository.findOne(id);
		} catch (Exception e) {
			salida = null;
		}
		return salida;
	}

	@PostMapping("/post")
	public Country add(@RequestBody Country country) {
		Country salida = null;
		try {
			countryRepository.save(country);
			salida = country;
		} catch (Exception e) {
			salida = null;
		}
		return salida;
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Integer id) {
		boolean salida = false;
		try {
			countryRepository.delete(id);
			salida = true;
		} catch (Exception e) {
			salida = false;
		}
		return salida;
	}

}