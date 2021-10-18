package com.fortmetais.pesagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortmetais.pesagem.model.ItemPesagem;
import com.fortmetais.pesagem.repository.ItemPesagens;

@Service
public class ItensPesagemService {
	
	@Autowired
	private ItemPesagens itemPesagens;
	
	@Transactional
	public ItemPesagem salvar(ItemPesagem itemPesagem) {
		
		return itemPesagens.saveAndFlush(itemPesagem);
	}	

}
