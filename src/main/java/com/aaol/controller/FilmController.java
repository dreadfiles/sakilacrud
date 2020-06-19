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

import com.aaol.entity.Film;
import com.aaol.repository.FilmRepository;

@RestController
@RequestMapping("/sakila/film")
public class FilmController {

	@Autowired
	FilmRepository filmRepository;

	@GetMapping("/getAll")
	public List<Film> getAll() {
		List<Film> salida = null;
		try {
			salida = filmRepository.findAll();
		} catch (Exception e) {
			salida = null;
		}
		return salida;
	}

	@GetMapping("/get/{id}")
	public Film get(@PathVariable Integer id) {
		Film salida = null;
		try {
			salida = filmRepository.findOne(id);
		} catch (Exception e) {
			salida = null;
		}
		return salida;
	}

	@PostMapping("/post")
	public Film add(@RequestBody Film film) {
		Film salida = null;
		try {
			filmRepository.save(film);
			salida = film;
		} catch (Exception e) {
			salida = null;
		}
		return salida;
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Integer id) {
		boolean salida = false;
		try {
			filmRepository.delete(id);
			salida = true;
		} catch (Exception e) {
			salida = false;
		}
		return salida;
	}

}