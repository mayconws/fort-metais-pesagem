package com.fortmetais.pesagem.repository.helper.clientes;

import java.util.List;

import com.fortmetais.pesagem.dto.ClienteDTO;

public interface ClientesQueries {
	
	public List<ClienteDTO> buscarPorNomeOuCnpj(String nomeOuCnpj);

}
