package com.fortmetais.pesagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortmetais.pesagem.model.Grupo;

public interface Grupos extends JpaRepository<Grupo, Long> {
	
}
