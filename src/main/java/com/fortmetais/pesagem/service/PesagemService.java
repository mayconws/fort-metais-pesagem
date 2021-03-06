package com.fortmetais.pesagem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortmetais.pesagem.model.Pesagem;
import com.fortmetais.pesagem.model.Produto;
import com.fortmetais.pesagem.repository.Pesagens;

@Service
public class PesagemService {
	
	@Autowired
	private Pesagens pesagens;
	
	private List<Produto> produtos = new ArrayList<>();
	
	@Transactional
	public Pesagem salvar(Pesagem pesagem) {
		
		return pesagens.saveAndFlush(pesagem);
	}

}
