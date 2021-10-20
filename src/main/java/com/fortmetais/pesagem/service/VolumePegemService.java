package com.fortmetais.pesagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortmetais.pesagem.model.VolumePesagem;
import com.fortmetais.pesagem.repository.VolumePesagens;

@Service
public class VolumePegemService {
	
	@Autowired
	private VolumePesagens volumePesagens;
	
	@Transactional
	public VolumePesagem salvar(VolumePesagem volumePesagem) {
		
		return volumePesagens.saveAndFlush(volumePesagem);
	}	

}
