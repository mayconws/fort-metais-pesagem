package com.fortmetais.pesagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortmetais.pesagem.model.VolumePesagem;

public interface VolumePesagens extends JpaRepository<VolumePesagem, Long> {

}
