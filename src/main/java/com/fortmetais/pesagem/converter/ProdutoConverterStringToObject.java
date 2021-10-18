package com.fortmetais.pesagem.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fortmetais.pesagem.model.Produto;
import com.fortmetais.pesagem.repository.Produtos;

@Component
public class ProdutoConverterStringToObject implements Converter<String, Produto> {
	
	@Autowired
	private Produtos produtos;
	
	@Override
	public Produto convert(String text) {
		if (text.isEmpty()) {
			return null;
		}		
		
		Optional<Produto> produtoOptional = produtos.findByNome(text);
		return produtoOptional.get();
	}
}
