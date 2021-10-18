package com.fortmetais.pesagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fortmetais.pesagem.dto.ClienteDTO;
import com.fortmetais.pesagem.repository.Clientes;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private Clientes clientes;
	
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ClienteDTO> pesquisar(String nomeOuCnpj) {
		return clientes.porNomeOuCnpj(nomeOuCnpj);
	}

}
