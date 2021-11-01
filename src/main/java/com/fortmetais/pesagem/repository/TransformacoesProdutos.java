package com.fortmetais.pesagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortmetais.pesagem.model.TransformacaoProduto;

public interface TransformacoesProdutos extends JpaRepository<TransformacaoProduto, Long> {
		

}
