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

import com.aaol.entity.Language;
import com.aaol.repository.LanguageRepository;

@RestController
@RequestMapping("/sakila/language")
public class LanguageController {

	@Autowired
	LanguageRepository languageRepository;

	@GetMapping("/getAll")
	public List<Language> getAll() {
		List<Language> salida = null;
		try {
			salida = languageRepository.findAll();
		} catch (Exception e) {
			salida = null;
		}
		return salida;
	}

	@GetMapping("/get/{id}")
	public Language get(@PathVariable Integer id) {
		Language salida = null;
		try {
			salida = languageRepository.findOne(id);
		} catch (Exception e) {
			salida = null;
		}
		return salida;
	}

	@PostMapping("/post")
	public Language add(@RequestBody Language language) {
		Language salida = null;
		try {
			languageRepository.save(language);
			salida = language;
		} catch (Exception e) {
			salida = null;
		}
		return salida;
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Integer id) {
		boolean salida = false;
		try {
			languageRepository.delete(id);
			salida = true;
		} catch (Exception e) {
			salida = false;
		}
		return salida;
	}

}