package com.fortmetais.pesagem.repository.helper.produtos;

import java.util.List;

import com.fortmetais.pesagem.dto.ProdutoDTO;

public interface ProdutosQueries {
	
	public List<ProdutoDTO> produtoPorNome(String nomeProduto);	
		

}
