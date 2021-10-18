package com.fortmetais.pesagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fortmetais.pesagem.dto.ProdutoDTO;
import com.fortmetais.pesagem.repository.Produtos;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private Produtos produtos;
	
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ProdutoDTO> pesquisar(String nomeProduto) {
		return produtos.produtoPorNome(nomeProduto);
	}

}
