package com.fortmetais.pesagem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fortmetais.pesagem.model.Cliente;
import com.fortmetais.pesagem.repository.helper.clientes.ClientesQueries;

public interface Clientes extends JpaRepository<Cliente, Long>, ClientesQueries {
	
	Optional<Cliente> findByNome(String nome);
	
	@Query("FROM Cliente ORDER BY id DESC")
	List<Cliente> findLastId();	

}
