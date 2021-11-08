package com.fortmetais.pesagem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fortmetais.pesagem.model.Cliente;
import com.fortmetais.pesagem.model.Produto;
import com.fortmetais.pesagem.repository.helper.produtos.ProdutosQueries;

public interface Produtos extends JpaRepository<Produto, Long>, ProdutosQueries {
	
	Optional<Produto> findByNome(String nome);
	
	@Query("FROM Produto ORDER BY id DESC")
	List<Produto> findLastId();	

}
