package com.aaol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aaol.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

}