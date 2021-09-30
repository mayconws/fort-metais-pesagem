package com.fortmetais.pesagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortmetais.pesagem.model.Cliente;
import com.fortmetais.pesagem.repository.helper.clientes.ClientesQueries;

public interface Clientes extends JpaRepository<Cliente, Long>, ClientesQueries {

}
