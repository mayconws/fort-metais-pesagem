package com.fortmetais.pesagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortmetais.pesagem.model.ItemPesagem;

public interface ItemPesagens extends JpaRepository<ItemPesagem, Long> {

}
