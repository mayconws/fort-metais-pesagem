package com.fortmetais.pesagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortmetais.pesagem.model.Pesagem;

public interface Pesagens extends JpaRepository<Pesagem, Long> {

}
