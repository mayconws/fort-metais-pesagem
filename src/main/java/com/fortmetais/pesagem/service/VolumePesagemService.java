package com.fortmetais.pesagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortmetais.pesagem.model.Pesagem;
import com.fortmetais.pesagem.repository.Pesagens;

@Service
public class VolumePesagemService {
	
	@Autowired
	private Pesagens pesagens;
	
	@Transactional
	public Pesagem salvar(Pesagem pesagem) {
		
		return pesagens.saveAndFlush(pesagem);
	}

}
