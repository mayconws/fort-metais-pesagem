package com.fortmetais.pesagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortmetais.pesagem.model.Produto;
import com.fortmetais.pesagem.repository.helper.produtos.ProdutosQueries;

public interface Produtos extends JpaRepository<Produto, Long>, ProdutosQueries {

}
