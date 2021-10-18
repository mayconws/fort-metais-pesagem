package com.fortmetais.pesagem.repository.helper.produtos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fortmetais.pesagem.dto.ProdutoDTO;

public class ProdutosImpl implements ProdutosQueries {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<ProdutoDTO> produtoPorNome(String nomeProduto) {
		String jpql = "select new com.fortmetais.pesagem.dto.ProdutoDTO(id, nome, codReferencia) "
				+ "from Produto where (lower(nome) like lower(:nomeProduto) or lower(codReferencia) like lower(:nomeProduto)) ";
		List<ProdutoDTO> produtosFiltrados = manager.createQuery(jpql, ProdutoDTO.class)
					.setParameter("nomeProduto", "%" + nomeProduto + "%")
					.getResultList();
		return produtosFiltrados;
	}

}
