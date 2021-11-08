package com.fortmetais.pesagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortmetais.pesagem.model.TransformacaoProduto;
import com.fortmetais.pesagem.repository.TransformacoesProdutos;

@Service
public class TransformacaoProdutoService {
	
	@Autowired
	private TransformacoesProdutos transformacoesProdutos;
	
	@Transactional
	public TransformacaoProduto salvar(TransformacaoProduto transformacaoProduto) {
		
		return transformacoesProdutos.saveAndFlush(transformacaoProduto);
	}

}
