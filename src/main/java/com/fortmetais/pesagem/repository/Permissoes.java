package com.fortmetais.pesagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortmetais.pesagem.model.Permissao;

public interface Permissoes extends JpaRepository<Permissao, Long> {
	
}
