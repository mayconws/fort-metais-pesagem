package com.fortmetais.pesagem.repository.helper.clientes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fortmetais.pesagem.dto.ClienteDTO;

public class ClientesImpl implements ClientesQueries {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<ClienteDTO> porNomeOuCnpj(String nomeOuCnpj) {
		String jpql = "select new com.fortmetais.pesagem.dto.ClienteDTO(id, upper (nome), cnpj) "
				+ "from Cliente where (lower(nome) like lower(:nomeOuCnpj) or lower(cnpj) like lower(:nomeOuCnpj)) ";
		List<ClienteDTO> clientesFiltrados = manager.createQuery(jpql, ClienteDTO.class)
					.setParameter("nomeOuCnpj", "%" + nomeOuCnpj + "%")
					.getResultList();
		return clientesFiltrados;
	}

}
