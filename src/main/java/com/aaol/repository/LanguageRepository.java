package com.aaol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aaol.entity.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

}